package org.stepdefinition;
import java.util.Date;

import org.junit.BeforeClass;
import org.test.api.testrunner.GenerateHTMLReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends GenerateHTMLReport {
	@Before(order = 1)
	public void beforeEachScenario() {
		System.out.println("Scenario started");
	}
	
	@After(order=1)
	public void afterEachScenario() {
		System.out.println("Scenario completed");
	}

	@Before(order=2)
	
	public void startTime() {
		System.out.println("Scenario starts at :" + new Date());
	}
	
	@After(order=2)
	public void endTime() {
		System.out.println("Scenario Ends at " + new Date());
	}
	
	// Config the extent report Configuration
	@BeforeClass
	public void reportStart() {
		configReport(System.getProperty("user.dir")+"\\Reports\\ExtentReports\\extentReports.html");
		System.out.println("ExtentRepot Config Done");
	}
	
	@After
	public void generateReport(Scenario s) {
		createReport(s);
		tearDown();
		System.out.println( "Extent Report generated");
	}
}
