package org.stepdefinition;

import java.util.Date;

import org.junit.BeforeClass;
import org.test.api.baseclass.BaseClass;
import org.test.api.testrunner.GenerateHTMLReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends GenerateHTMLReport {
	public BaseClass baseclass;

	@Before(order = 1)
	public void beforeEachScenario(Scenario s) {
		baseclass.logger.info("Scenario Started : " + s.getName());
	}

	@After(order = 1)
	public void afterEachScenario(Scenario s) {
		baseclass.logger.info("Scenario completed : " + s.getName());
	}

	@Before(order = 2)

	public void startTime() {
		System.out.println("Scenario starts at :" + new Date());
	}

	@After(order = 2)
	public void endTime() {
		System.out.println("Scenario Ends at " + new Date());
	}

	// Config the extent report Configuration
	/*
	 * @BeforeClass public void reportStart() {
	 * configReport(System.getProperty("user.dir") +
	 * "\\Reports\\ExtentReports\\extentReports.html");
	 * baseclass.logger.info("ExtentRepot Config Done"); }
	 */

	@After
	public void generateReport(Scenario s) {
		createReport(s);
		tearDown();
		baseclass.logger.info("Extent Report generated");

	}
}
