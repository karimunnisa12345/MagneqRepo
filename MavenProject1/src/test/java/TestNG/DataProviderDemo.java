package TestNG;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ListenerClass.class)
public class DataProviderDemo {
	WebDriver driver;		
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}	
	@Test(dataProvider = "TestData")
	public void loginOperation(String un,String pwd) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		driver.navigate().back();
	}		
	@DataProvider(name="TestData")
	public Object[][] getData()
	{
		Object data[][]=new Object[3][2];
		data[0][0]="Admin";
		data[0][1]="admin123";
		
		data[1][0]="admin";
		data[1][1]="admin123";
		
		data[2][0]="Admin";
		data[2][1]="admin";		
		return data;		
	}	
}
