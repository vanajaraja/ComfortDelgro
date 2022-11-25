package org.test.api.payloads;

import org.test.api.baseclass.BaseClass;

public class SignInPayLoad {
	
	public static String signIn(String email, String password)  {
		
		return "{\r\n" + 
				"  \"user\": {\r\n" + 
				"    \"email\": \""+email+"\",\r\n" + 
				"    \"password\": \""+password+"\"\r\n" + 
				"  }\r\n" + 
				"}";
		
	}

}
