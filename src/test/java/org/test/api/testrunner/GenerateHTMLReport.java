package org.test.api.testrunner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.Scenario;

public class GenerateHTMLReport {

	public static ExtentHtmlReporter htmlReport ;
	public static ExtentReports e;
	
	//Set the configuration for the extent reports
	public static void configReport(String location) {
		htmlReport = new ExtentHtmlReporter(location);
		htmlReport.config().setDocumentTitle("React Real World");
		htmlReport.config().setReportName("React Real World Test Scenario");
		htmlReport.config().setTheme(Theme.DARK);
		
		e = new ExtentReports();
		e.attachReporter(htmlReport);
		e.setSystemInfo("Sprint", "R V12.3.2");
		e.setSystemInfo("BaseURI","https://api.realworld.io");
	}
	// Create the extent html rport
	public static void createReport(Scenario s) {
		String testName = s.getName();
		switch (s.getStatus()) {
		case PASSED:
			e.createTest(testName).pass("Scenario Passed");
			break;
		case FAILED:
			e.createTest(testName).fail("Scenario Failed");
		break;
		default:
			e.createTest(testName).skip("Scenario Skipped");
			break;
		}
		
	}
	
	public static void tearDown() {
		e.flush();

	}



}
