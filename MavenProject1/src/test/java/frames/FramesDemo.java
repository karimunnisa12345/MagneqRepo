package frames;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemo {
WebDriver driver;
@BeforeClass
public void setUp() throws InterruptedException, Exception
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.automationtesting.in/Frames.html");
	Thread.sleep(5000);
}
@Test(priority=1)
public void singleFrameOperation() throws Exception
{
	driver.findElement(By.xpath("//a[text()='Single Iframe ']")).click();
	WebElement singleframe=driver.findElement(By.xpath("//iframe[@id='singleframe']"));
	driver.switchTo().frame(singleframe);
	//driver.switchTo().frame(0);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("selenium");
	driver.switchTo().defaultContent(); // driver will move out from that frame and will point to the webpage
	Thread.sleep(3000);
}

@Test(priority=2,enabled=false)
public void multipleFrameOperation()
{
	driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
	WebElement oframe=driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
	driver.switchTo().frame(oframe);
	WebElement inframe=driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
	driver.switchTo().frame(inframe);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("selenium with java");
	driver.switchTo().defaultContent();
}




}
