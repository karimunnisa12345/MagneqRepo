package robot;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadingDemo {
WebDriver driver;	
	@BeforeClass
	public void setUp() throws InterruptedException, Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		Thread.sleep(5000);
	}
	@Test(priority=1)
	public void uploadOperation() throws Exception
	{
		driver.findElement(By.xpath("//a[text()='Register']")).click();	
		driver.findElement(By.xpath("//div[@class='radioWrap']/div[1]")).click();
		Thread.sleep(3000);
		WebElement uploadResume=driver.findElement(By.xpath("//button[text()='Upload Resume']"));
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", uploadResume);
		uploadResume.click();
		Thread.sleep(2000);
		Robot rb=new Robot();		
		StringSelection sc=new StringSelection("C:\\Users\\91970\\Desktop\\karimunnisaData\\FResume.docx");	
		//we have to copy this path to clipboard 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sc, null);
		//ctrl+v
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);	
	}
	
	
	
	
	
}
