package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class controlkeyinvention {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		WebElement textbox1=driver.findElement(By.xpath("//textarea[@placeholder='Paste one version of a text here.']"));
		Thread.sleep(1000);
		textbox1.sendKeys("text box (input box), text field or text entry box is a control element of  text box (input box), text field or text entry box is a control element of");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.keyDown(textbox1, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		WebElement textbox2=driver.findElement(By.xpath("//textarea[@placeholder='Paste another version of the text here.']"));
		Thread.sleep(1000);
		action.keyDown(textbox2, Keys.CONTROL).sendKeys("v").build().perform();
		
		
		Thread.sleep(3000);
		driver.close();
		

	}

}
