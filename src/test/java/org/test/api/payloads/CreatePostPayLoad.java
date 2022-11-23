package org.test.api.payloads;

public class CreatePostPayLoad {
	
	public static String createPost(String title, String descip, String body, String tagList, int num) {
		return "{\r\n" + 
				"  \"article\": {\r\n" + 
				"    \"title\": "+"\""+title+num+"\""+",\r\n" + 
				"    \"description\": "+"\""+descip+"\""+",\r\n" + 
				"    \"body\": "+"\""+body+"\""+",\r\n" + 
				"    \"tagList\": "+"\""+tagList+"\""+"\r\n" + 
				"  }\r\n" + 
				"}";
		

	}

}
