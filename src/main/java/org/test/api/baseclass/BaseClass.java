package org.test.api.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.*;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	public static int statusCode(Response response) {
		System.out.println("Status Code " + response.getStatusCode());
		return response.getStatusCode();

	}

	public static String getResp(Response response) {
		String res = response.getBody().asString();
		return res;

	}

	public static void getvalue(String response, String key) throws ParseException {

		JSONParser j = new JSONParser();
		Object object = j.parse(response);
		JSONObject o = (JSONObject) object;
		Long value = (Long) o.get(key);
		System.out.println(value);

	}

	public static String getStringvalue(String response, String jsonObjectKey,String key) throws ParseException {

		JSONObject jsonObject = new JSONObject(response);
		JSONObject getSth = jsonObject.getJSONObject(jsonObjectKey);
		Object object = getSth.get(key);
		String value = (String) object;
		System.out.println(value);

		/*
		 * JSONParser j = new JSONParser(); Object object = j.parse(response);
		 * JSONObject o = (JSONObject) object; String value = (String) o.get(key);
		 * System.out.println(value);
		 */
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
		// TODO Auto-generated method stub
		String props = null;

		try {
			String filePath = System.getProperty("user.dir") + "\\Inputs\\config.properties";
			Properties p = new Properties();
			FileReader f = new FileReader(filePath);
			p.load(f);
			props = p.getProperty(propKey);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}

	public static String dateAndTimeFormatToAppendReports() {
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String format = s.format(new Date());
		return format;

	}
	// public static void getToken() {
	// TODO Auto-generated method stub
	// PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
	// authScheme.setUserName("test202201@gmail.com");
	// authScheme.setPassword("test@2022");
	// RestAssured.authentication = authScheme;
	// }
}
