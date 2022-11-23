package org.test.api.testrunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.test.api.baseclass.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class GenerateJVMReport {

	public static void generateJvmreports(String jsonFiles) {
		File f = new File(System.getProperty("user.dir") + "\\Reports\\JvmReports"
				+ BaseClass.dateAndTimeFormatToAppendReports());

		Configuration con = new Configuration(f, "React Real World application Api Testing");
		con.addClassifications("Base URI", "https://api.realworld.io");

		List<String> li = new ArrayList<String>();
		li.add(jsonFiles);
		ReportBuilder rb = new ReportBuilder(li, con);
		rb.generateReports();
	}
}
