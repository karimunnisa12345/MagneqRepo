package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotationsDemo {

	//@Test - to indicate each method as testng method	
	@Test
	public void display1()
	{
		System.out.println("This is display1 method");
	}	
	@Test
	public void display2()
	{
		System.out.println("This is display2 method");
	}	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("This is beforemethod which will execute before each Test method");
	}	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("This is afterMethod which will execute after each Test method");
	}	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("This is beforeClass which will execute before exeuction of this current class");
	}	
	@AfterClass
	public void afterClass()
	{
		System.out.println("This is afterClass which will execute after execution of entire current class");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Thsi is beforeTest which will execute before execution of multiple classes.");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("This is afterTest which will execute after execution of multiple classes.");
	}
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("This is beforeSuite which will execute before execution of multiple testcases.");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("This is aftersuite which will execute after execution of multipe testcases..");
	}
	
	
	
	
}
