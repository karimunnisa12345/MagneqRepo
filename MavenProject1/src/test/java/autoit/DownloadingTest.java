package autoit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadingTest {
	WebDriver driver;	
	@BeforeClass
	public void setUp() throws InterruptedException, Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/download");
		Thread.sleep(5000);
	}
	@Test(priority=1)
	public void uploadOperation() throws Exception
	{
		driver.findElement(By.linkText("selenide-intro.txt")).click();	
		
		java.lang.Runtime.getRuntime().exec("D:\\autoit\\newDownloadScript.exe");
	}
}
