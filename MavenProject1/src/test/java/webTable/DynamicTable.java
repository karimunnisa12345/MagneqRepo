package webTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException, Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.timeanddate.com/worldclock/");
		Thread.sleep(5000);
	}
	@Test(priority=1)
	public void singleFrameOperation() throws Exception
	{
		WebElement table=driver.findElement(By.xpath("//table[@class='zebra fw tb-theme']"));
		//fetch all the rows from this table
		
		List<WebElement> nrows=table.findElements(By.tagName("tr"));
		System.out.println("Total noof rows are: "+ nrows.size());
		
		for(int i=0;i<nrows.size();i++) // for rows i=0;i<37;i++
		{
			List<WebElement> ncols=nrows.get(i).findElements(By.tagName("td")); // 0th row all cols
			
			// nrows.get(0).td's
			
			for(int j=0;j<ncols.size();j++)// for columns
			{
				System.out.print(ncols.get(j).getText()+ "   ");
			}
			System.out.println();
		}		
	}
	
}
