package sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadingFile {

	//uploading option using Sikuli
	WebDriver driver;	
	@BeforeClass
	public void setUp() throws InterruptedException, Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(6000);
	}
	@Test(priority=1)
	public void uploadOperation() throws Exception
	{
		Thread.sleep(3000);
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
		
		Screen sc=new Screen();
		Pattern filetextbox=new Pattern("D:\\sikuliscreenshots\\newfileupload.png");
		Pattern openbtn=new Pattern("D:\\sikuliscreenshots\\newopenbtn.png");
		
		sc.type(filetextbox, "C:\\Users\\91970\\Desktop\\pic.png");
		Thread.sleep(3000);
		sc.click(openbtn);
		
	}
		
		
		
	
	
	
}
