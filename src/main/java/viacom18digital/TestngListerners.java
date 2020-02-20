package viacom18digital;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListerners extends GenericClass implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) 
	{
		//System.out.println("Your test is started and the result" +result.getStatus());
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
	
		/*
		 * System.out.println("Testcase execution is success");
		 * 
		 * try { mail(result.isSuccess()); } catch (EmailException e) {
		 * e.printStackTrace(); }
		 */
		 
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		System.out.println("Testcase failed");
		TakeScreenshot(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
		
	}

	@Override
	public void onStart(ITestContext result)
	{
		
		
	}

	@Override
	public void onFinish(ITestContext result) 
	{
		System.out.println("All the testcases are executed successfully and report is generated" +result.getAllTestMethods());
		
	}

}
