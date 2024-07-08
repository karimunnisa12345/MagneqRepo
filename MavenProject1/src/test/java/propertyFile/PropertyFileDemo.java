package propertyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyFileDemo {
	WebDriver driver;
	FileInputStream fis;
	FileOutputStream fos;
	Properties pr;
	
	@BeforeClass
	public void setUp() throws InterruptedException, Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		fis=new FileInputStream("D:\\EclipseNewWorkspace\\MavenProject1\\src\\test\\resources\\login.properties");
		pr=new Properties();
		pr.load(fis);
		driver.get(pr.getProperty("appURL"));
		Thread.sleep(3000);
	}
	@Test
	public void loginOperation() throws Exception
	{
		fis=new FileInputStream("D:\\\\EclipseNewWorkspace\\\\MavenProject1\\\\src\\\\test\\\\resources\\\\login.properties");
		pr=new Properties();
		pr.load(fis);
		driver.findElement(By.id(pr.getProperty("userid"))).sendKeys(pr.getProperty("username"));
		driver.findElement(By.xpath(pr.getProperty("pwdxpath"))).sendKeys(pr.getProperty("password"));
		driver.findElement(By.xpath(pr.getProperty("loginbtnxpath"))).click();
	}
	

}
