package com.internship.task4;

import java.util.ResourceBundle;

public class Configuration {
	public static final String PROPERTY_BUNDLE="convertor_key";
	private static String apiKey=null;
	public static String getApiKey() {
		if(apiKey==null)loadProperties();
		return apiKey;
	}
	private static void loadProperties() {
		try {
			ResourceBundle bundle=ResourceBundle.getBundle(PROPERTY_BUNDLE);
			apiKey=bundle.getString("api.key");
		}catch(java.util.MissingResourceException ex) {
			System.out.printf("Please create a properties file named: %s.properties\n", PROPERTY_BUNDLE);
			System.out.println("Containing your API Key in the format:");
			System.out.println("api.key = 1234567890ABCDEF");
			System.out.println("Add the file to the application classpath, e.g. in src/ directory.");
			System.exit(1);
		}
	}
}
