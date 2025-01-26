package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathbytext {

	public static void main(String[] args) throws InterruptedException {

System.setProperty("webdriver.chrome.driver","D:\\workspace\\Selenium\\Driver\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("https://www.facebook.com/");
driver.manage().window().maximize();
Thread.sleep(3000);

WebElement softwaretesting = driver.findElement(By.xpath("//a[text()='Forgotten password?']"));
softwaretesting.click();

Thread.sleep(3000);
driver.close();
	}

}
