package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathlocatorbyindex {

	public static void main(String[] args) throws InterruptedException {
		//Golden line 
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.guru99.com/");
		driver.manage().window().maximize();
		Thread.sleep(3500);
		
		WebElement java = driver.findElement(By.xpath("(//img[@class='lazyloaded'])[5]"));
		java.click();
		
		Thread.sleep(3500);
		
		driver.close();

	}

}
