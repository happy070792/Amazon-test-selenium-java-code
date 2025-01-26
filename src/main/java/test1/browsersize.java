package test1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browsersize {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		//x=1000pixel
		//y=500 pixel
		Dimension p=new Dimension(1000,500);
		driver.manage().window().setSize(p);
		Thread.sleep(5000);
		
		int x=driver.manage().window().getSize().getWidth();
		int y=driver.manage().window().getSize().getHeight();
		
		System.out.println("new width is :"+x+"new height is:"+y);
		
		driver.close();

	}

}
