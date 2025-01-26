package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class partilipi {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.pratilipi.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement marathi=driver.findElement(By.xpath("//span[text()='Marathi']"));

		//scroll by web element
		js.executeScript("arguments[0].scrollIntoView(true);",marathi);

		Thread.sleep(2000);
		marathi.click();
		WebElement signin=driver.findElement(By.xpath("//span[text()='साइन इन']"));
		signin.click();
		Thread.sleep(3000);
		Set<String> add=driver.getWindowHandles();
		List<String> address=new ArrayList(add);
		System.out.println(address);
		WebElement facebook=driver.findElement(By.xpath("(//button[@class='fb'])[3]"));
		facebook.click();
		Thread.sleep(3000);
		//
		WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("priyankagmhatre@gmail.com");
		Thread.sleep(3000);
		WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("**");
		Thread.sleep(3000);


			}

	}


