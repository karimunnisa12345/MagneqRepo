package cookies;

import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookieDemo {
WebDriver driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException, Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.timeanddate.com/worldclock/");
		Thread.sleep(5000);
	}
	@Test(priority=1)
	public void singleFrameOperation() throws Exception
	{
		Set<Cookie> ncookies=driver.manage().getCookies();
		System.out.println("Total noof cookies :" + ncookies.size() );
	
		for(Cookie c:ncookies)
		{
			System.out.println(c.getDomain());
			System.out.println(c.getName());
			System.out.println(c.getExpiry());
		}
		
		driver.manage().deleteAllCookies();
		ncookies=driver.manage().getCookies();
		System.out.println("Total noof cookies :" + ncookies.size() ); 
		
		
	}
}
