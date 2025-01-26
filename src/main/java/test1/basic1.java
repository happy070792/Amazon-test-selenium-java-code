package test1;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basic1 {

	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		
		Point p= new Point(500,300);
		driver.manage().window().setPosition(p);
		
		 System.out.println(driver.manage().window().getPosition().getX());
		 
		 System.out.println(driver.manage().window().getPosition().getY());
		 
		 Thread.sleep(5000);
		 driver.close();

	}

}
