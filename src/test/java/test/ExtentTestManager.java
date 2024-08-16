package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class ExtentTestManager {
	private static ExtentReports extentReports;
	public static ExtentReports getReporter() {
	if (extentReports == null) {
		ExtentHtmlReporter htmlReporter = 
		new ExtentHtmlReporter
		(System.getProperty("user.dir")
		+ "/test-output/repo.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);}
	return extentReports;}}