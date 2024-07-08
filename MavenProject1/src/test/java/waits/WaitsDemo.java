package waits;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsDemo {
	WebDriver driver;	
	@BeforeClass
	public void setUp() throws InterruptedException, Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //implicitwait		
	}
	@Test(priority=1)
	public void uploadOperation() throws Exception
	{
		WebElement grocery=driver.findElement(By.xpath("//img[@alt='Grocery']"));
		
		//explicit wait
		/*
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1));
		
		WebElement grocery=driver.findElement(By.xpath("//img[@alt='Grocery']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(grocery));
		*/
		
		//fluentwait declaration
		Wait<WebDriver> myWait=new FluentWait<WebDriver>(driver)
				   .withTimeout(Duration.ofSeconds(1))
				   .pollingEvery(Duration.ofSeconds(1))
				   .ignoring(Exception.class);

		WebElement aboutLink=myWait.until(new Function<WebDriver,WebElement>()
	{			
		public WebElement apply(WebDriver driver)
		{
		return driver.findElement(By.xpath("//img[@alt='Grocery']"));
			
		}
		});
		grocery.click();
	}
	
	
	
	
	
	
}


