package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;	
	@Parameters("appUrl")
	@BeforeTest(groups = "smoke")
	public void setUp(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}
	@Parameters({"username","password"})
	@Test(priority=1,groups="sanity")
	public void loginOperation(String un,String pwd)
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}	
	@Test(priority=3,invocationCount = 1)//enabled=false)
	public void validateLoginByUrl()
	{
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index1";
		/*if(actualUrl.equals(expectedUrl))
		{
			System.out.println("Login Successfull..");
		}
		else
		{
			System.out.println("Login UnSuccessful..");
		}*/
		
		//HardAssertion - Assert
		Assert.assertEquals(actualUrl, expectedUrl, "Validate Login By Url Failed..");
		
		System.out.println("Remaining statements...");
		
	}	
	@Test(priority=2,dependsOnMethods = "validateLoginByUrl")
	public void validateLoginByText() throws InterruptedException
	{
		WebElement dashboardText=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		String actualText=dashboardText.getText();
		String expectedText="Dashboard123";
		/*
		if(actualText.equals(expectedText))
		{
			System.out.println("Login Successfull..");
		}
		else
		{
			System.out.println("Login UnSuccessful..");
		}*/
		Thread.sleep(3000);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualText, expectedText, "Validation of login by Text got failed..");
		
		System.out.println("Remaining stmts from softassertion");
		sa.assertAll();
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}
