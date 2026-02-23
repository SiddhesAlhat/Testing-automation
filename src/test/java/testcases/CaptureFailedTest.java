package testcases;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CaptureFailedTest implements ITestListener{
	 @Override
	public void onTestFailure(ITestResult result) {
		 System.out.println("Failed Test Case Name Is:  "+result.getMethod().getMethodName());
		 MyntraKidsModule.captureScreenshot(result.getMethod().getMethodName()+".png");
		                                  //  verifyNegativeTestCaseOnEnterNumber() 
	}

}
 