package org.test.api.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.*;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	public static Logger logger;

	public static int statusCode(Response response) {
		logger.info("Status Code " + response.getStatusCode());
		return response.getStatusCode();

	}

	public static String getResp(Response response) {
		String res = response.getBody().asString();
		return res;

	}

	public static String getStringvalue(String response, String jsonObjectKey, String key) throws ParseException {

		JSONObject jsonObject = new JSONObject(response);
		JSONObject getSth = jsonObject.getJSONObject(jsonObjectKey);
		Object object = getSth.get(key);
		String value = (String) object;
		return value;

	}

	public static String getStringValueFromJsonArray(String response, String jsonObjectKey, String key) {
		JSONObject jsonObject = new JSONObject(response);
		JSONObject getSth = jsonObject.getJSONObject(jsonObjectKey);
		JSONArray js = (JSONArray) getSth.get(key);
		Object object = js.get(0);
		String value = (String) object;
		return value;

	}

	// Generating serial to append with email id and username to get unique username
	// and email address

	public static int serialNumtoAppendemailID() {

		int num = 0;
		try {
			String filePath = System.getProperty("user.dir") + "\\Inputs\\config.properties";
			Properties p = new Properties();
			FileReader f = new FileReader(filePath);
			p.load(f);
			num = Integer.parseInt(p.getProperty("serialNumber"));

			p.load(new FileInputStream(filePath));
			p.setProperty("serialNumber", Integer.toString(num + 1));

			System.out.println(p.getProperty("serialNumber"));
			p.store(new FileOutputStream(filePath), null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;

	}

	public static String getDataFromConfigPropertyFile(String propKey) {
		String props = null;

		try {
			String filePath = System.getProperty("user.dir") + "\\Inputs\\config.properties";
			Properties p = new Properties();
			FileReader f = new FileReader(filePath);
			p.load(f);
			props = p.getProperty(propKey);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

	public static String dateAndTimeFormatToAppendReports() {
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String format = s.format(new Date());
		return format;

	}

	public static void writeLogFile() throws SecurityException, IOException {
		logger = Logger.getLogger("MyLog");
		FileHandler fh;
		String dataAndTime = dateAndTimeFormatToAppendReports();

		try {

			String filePath = System.getProperty("user.dir") + "\\Reports\\TestLogFile" + dataAndTime + ".log";
			fh = new FileHandler(filePath);
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
