package TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart results are: " + result.getName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess results are: "+ result.getName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure results are: "+result.getName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped results are: "+result.getName());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailureButWithinSuccessPercentage results are: "+result.getName());
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout results are: "+result.getName());
	}
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart results are: "+ context.getName());
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish results are: "+ context.getName());
	}
	
	
	
	

}
