package apachePoi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LoginTest {
	WebDriver driver;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook book;
	XSSFSheet sheet;
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
	}	
	@Test
	public void loginOperation() throws Exception
	{
		fis=new FileInputStream("C:\\Users\\91970\\Desktop\\Demo.xlsx");
		book=new XSSFWorkbook(fis);
		sheet=book.getSheet("login");		
		driver.findElement(By.id("user-name")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());	
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}
	@Test
	public void loginValidation() throws IOException
	{
		String expectedURL=sheet.getRow(1).getCell(2).getStringCellValue();
		String actualURL=driver.getCurrentUrl();
		
		sheet.getRow(1).createCell(3).setCellValue(actualURL);
		
		if(expectedURL.equals(actualURL))
		{
			sheet.getRow(1).createCell(4).setCellValue("PASS");
			System.out.println("Login Success..");
		}
		else
		{
			sheet.getRow(1).createCell(4).setCellValue("FAIL");
			System.out.println("Login Fail");
		}
		fos=new FileOutputStream("C:\\Users\\91970\\Desktop\\Demo.xlsx");
		book.write(fos);		
	}
}
