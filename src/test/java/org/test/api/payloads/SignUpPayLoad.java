package org.test.api.payloads;

public class SignUpPayLoad {
	public static String signUPUser(int num) {
			
	/*Num helps to generate new username and 
	 * email address for every sign up
	 * 
	 */
		return ("{\r\n" + 
				"  \"user\": {\r\n" + 
				"    \"username\": \"test2022"+num +"\",\r\n" + 
				"    \"email\": \"test2022"+ num+"@gmail.com\",\r\n" + 
				"    \"password\": \"Test@2022\"\r\n" + 
				"  }\r\n" + 
				"}");

	}
	
	public static String signUpUserInvalidData(String username, String email, String password) {
		if (username==null && email==null && password==null) {
		return "{\r\n" + 
				"  \"user\": {\r\n" + 
				"    \"username\": \"\",\r\n" + 
				"    \"email\": \"\",\r\n" + 
				"    \"password\": \"\"\r\n" + 
				"  }\r\n" + 
				"}";
		}
		else if (!(username == null) && !(email == null) && !(password==null))
		{
			return "{\r\n" + 
					"  \"user\": {\r\n" + 
					"    \"username\": "+"\""+username+"\""+",\r\n" + 
					"    \"email\": "+"\"" +email+"\""+",\r\n" + 
					"    \"password\": "+"\""+password+"\""+"\r\n" + 
					"  }\r\n" + 
					"}";
		}
		else if (!(username==null) && email==null && password==null)
		{
			return "{\r\n" + 
					"  \"user\": {\r\n" + 
					"    \"username\": "+"\""+username+"\""+",\r\n" + 
					"    \"email\": \"\",\r\n" + 
					"    \"password\": \"\"\r\n" + 
					"  }\r\n" + 
					"}";
		}

		else if (username==null && !(email==null) && password==null)
		{
			return "{\r\n" + 
					"  \"user\": {\r\n" + 
					"    \"username\": \"\",\r\n" + 
					"    \"email\": "+"\"" +email+"\""+",\r\n" + 
					"    \"password\": \"\"\r\n" + 
					"  }\r\n" + 
					"}";
		}
				
		else if (username==null && email==null && !(password==null))
		{
			return "{\r\n" + 
					"  \"user\": {\r\n" + 
					"    \"username\": \"\",\r\n" + 
					"    \"email\": \"\",\r\n" + 
					"    \"password\":"+"\""+password+"\""+ "\r\n" + 
					"  }\r\n" + 
					"}";
		}
		
		else if (!(username==null) && !(email==null) && password==null)
		{
			return "{\r\n" + 
					"  \"user\": {\r\n" + 
					"    \"username\":"+"\""+username+"\""+",\r\n" + 
					"    \"email\": "+"\"" +email+"\""+",\r\n" + 
					"    \"password\": \"\"\r\n" + 
					"  }\r\n" + 
					"}";
		}
		else if (!(username==null) && email==null && !(password==null))
		{
			return "{\r\n" + 
					"  \"user\": {\r\n" + 
					"    \"username\": "+"\""+username+"\""+",\r\n" + 
					"    \"email\": \"\",\r\n" + 
					"    \"password\": "+"\""+password+"\""+"\r\n" + 
					"  }\r\n" + 
					"}";
		}
		
		else if (username==null && !(email==null) && !(password==null))
		{
			return "{\r\n" + 
					"  \"user\": {\r\n" + 
					"    \"username\": \"\",\r\n" + 
					"    \"email\": "+"\"" +email+"\""+",\r\n" + 
					"    \"password\": "+"\""+password+"\""+"\r\n" + 
					"  }\r\n" + 
					"}";
		}
		
		
		return null;
		

	}
	

}
