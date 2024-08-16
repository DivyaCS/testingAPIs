package test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class ExtentTestListener implements ITestListener {
	private static ExtentReports extentReports = 
			ExtentTestManager.getReporter();
	private static ThreadLocal<ExtentTest> extentTest = 
			new ThreadLocal<>();
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = 
		extentReports.createTest(result.getMethod().getMethodName());
		extentTest.set(test);}
 
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");}
 
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, "Test Failed: " 
	+ result.getThrowable());}
 
	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test Skipped: " 
	+ result.getThrowable());}
 
	@Override
	public  void onStart(ITestContext context) {}
 
	@Override
	public void onFinish(ITestContext context) {extentReports.flush();}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {};}