package multipleWindows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowsDemo {

	static WebDriver driver;
	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(8000);
		
		String parentWindowId=driver.getWindowHandle(); // hrm window id
		
		driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']")).click();
		driver.findElement(By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']")).click();
		driver.findElement(By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']")).click();
		driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']")).click();
		
		Set<String> handles=driver.getWindowHandles();
		
		List<String> hList=new ArrayList<String>(handles);

		if(switchToRightWindow(hList, "Facebook"))
		{
			System.out.println(driver.getTitle()+ "    "+driver.getCurrentUrl());
		}		
		closeAllChildWindows(hList, parentWindowId);	
		switchToParentWindow(parentWindowId);
		System.out.println(driver.getTitle()+ "   "+driver.getCurrentUrl());
	}	
	public static void switchToParentWindow(String parentWindowId)
	{
		driver.switchTo().window(parentWindowId);
	}	
	public static void closeAllChildWindows(List<String> hList,String parentWindowId)
	{
		for(String s:hList) //hList -[facebookid,twitterid,youtubeid,..]
		{
			if(!s.equals(parentWindowId))
			{
				driver.switchTo().window(s).close();
			}
		}
	}	
	public static boolean switchToRightWindow(List<String> hList,String windowTitle)
	{
		for(String w:hList) // now this s contains all those window id's
		{
			String title=driver.switchTo().window(w).getTitle();
			if(title.contains(windowTitle))
			{
				System.out.println("driver switched to right window..");
				return true;
			}
		}
		return false;
	}
 
}
