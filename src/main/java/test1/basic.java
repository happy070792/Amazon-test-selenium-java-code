package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basic {

	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//up-casting done
		driver.get("https://www.amazon.in/");//web driver interface method
		driver.manage().window().maximize(); // method chaining -->method inside method
		Thread.sleep(3000);
		
		driver.navigate().to("https://www.facebook.com/");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		String s=driver.getTitle();
		System.out.println(s);
		String b=driver.getCurrentUrl();
		System.out.println(b);
		driver.close();
		

	}

}
