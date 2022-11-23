package org.test.api.testrunner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.test.api.baseclass.BaseClass;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = {
		"org.stepdefinition" }, dryRun = false, monochrome = true, tags = "@Functional", plugin = { "pretty",
				"html:Reports\\HtmlReports", 
				"json:Reports\\JsonReports\\SignupTCReports.json",
				"junit:Reports\\XmlReports\\SignupTCReports.xml" })

public class TestRunner extends BaseClass{
	
	@BeforeClass
	public static void reportStart() {
		String dateAndTime = BaseClass.dateAndTimeFormatToAppendReports();
		GenerateHTMLReport.configReport(System.getProperty("user.dir")+"\\Reports\\ExtentReports\\extentReports"+dateAndTime+".html");
		System.out.println("ExtentRepot Config Done");
	}
	
	@BeforeClass
	public static void logFileReport() throws Exception, IOException {
		writeLogFile();

	}

	
	@AfterClass
	public static void JvmReportgeneration() {
		String jsonFilePath = System.getProperty("user.dir") + "\\Reports\\JsonReports\\SignupTCReports.json";
		GenerateJVMReport.generateJvmreports(jsonFilePath);

	}
}
