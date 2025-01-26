package  test1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class amazonaddtocart {

	public static void main(String[] args) throws InterruptedException {
		
		//setup
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        
        // Open https://www.amazon.in/ in Chrome Browser.
		driver.get("https://www.amazon.in/");
				
		//Click on Electronics from dropdown menu and type “IPhone 13”
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("IPhone 13");
        
        //Get All the dropdown suggestions and validate all are related to searched product
        List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.s-suggestion")));
        for (WebElement suggestion : suggestions) {
            Assert.assertTrue(suggestion.getText().toLowerCase().contains("iphone 13"), "Suggestion not related to searched product: " + suggestion.getText());
        }
		
        //Then Type again “IPhone 13 128 GB” variant and Click “iPhone 13 128GB” variant from dropdown Result.
        searchBox.clear();
        searchBox.sendKeys("IPhone 13 128 GB");  
        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label = 'iphone 13 128 gb price']")));
        desiredOption.click();
       

        //From Results, click on the searched product and validate new tab is opened Navigate to next tab and click on Visit the Apple Store link appears below Apple iPhone 13 (128 GB) variant
        WebElement productLink =  driver.findElement(By.xpath("//h2[@aria-label='Apple iPhone 13 (128GB) - Green']"));
        String originalWindow = driver.getWindowHandle();
        productLink.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        WebElement appleStoreLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Visit the Apple Store']")));
        appleStoreLink.click();

        
        //Click on Apple Watch dropdown and select Apple Watch SE (GPS + Cellular)
       // WebElement wdrop= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-id='hamburger-button']"))); wdrop.click();
        //driver.findElement(By.xpath("//button[contains(@aria-label, 'Apple Watch')]")).click();
        WebElement watchDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@role='menuitem'][6]")));
        watchDropdown.click();
        WebElement appleWatchOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Apple Watch SE (GPS + Cellular)']")));
        appleWatchOption.click();
        
        //Hover on watch image and verify Quick Look is displayed for the watch.
        WebElement watchImage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[data-image-index='1']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(watchImage).perform();
        WebElement quickLook = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.quick-look")));
        Assert.assertTrue(quickLook.isDisplayed(), "Quick Look not displayed for the watch.");
        
        //Verify newly opened modal is related to Same product for which Quick look is performed.
        WebElement modalTitle = driver.findElement(By.cssSelector("div.modal-title"));
        Assert.assertTrue(modalTitle.getText().contains("Apple Watch SE (GPS + Cellular)"), "Modal title does not match the expected product.");
            
       
		
		//driver.quit();
		
	
	}

}
