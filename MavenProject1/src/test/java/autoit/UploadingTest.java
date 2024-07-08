package autoit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadingTest {
	WebDriver driver;	
	@BeforeClass
	public void setUp() throws InterruptedException, Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}
	@Test(priority=1)
	public void uploadOperation() throws Exception
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/child::li/a/span[text()='PIM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='oxd-file-div oxd-file-div--active']/button")).click();
		Thread.sleep(2000);
		
		//run autoit script
		java.lang.Runtime.getRuntime().exec("D:\\autoit\\newuploadscript.exe");
		
	}
}
