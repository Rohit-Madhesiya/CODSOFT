package com.internship.task4;

import java.io.*;
import java.net.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class ExchangeRateService {

	static final String SERVICE_URL="http://api.currencylayer.com/live?access_key=%s";

//	public static void main(String[] args) throws IOException{
//		// TODO Auto-generated method stub
//		String data;
//		data=queryExchangeRates(new String[] {"INR","NZD"});
//		System.out.println(data);
//		System.out.println("Get exchange rate for a single currency:");
//		System.out.println( "USD = "+parseRate("NZD", data) );
//		System.out.println( "INR = "+parseRate("INR", data) );
//	}
	
	public static String queryExchangeRates(String[] currencyCodes) throws IOException {
		final String CURRENCY_PARAM = "&currencies=%s";
		String urlstring = String.format(SERVICE_URL, Configuration.getApiKey() );
		if (currencyCodes.length > 0) {
			urlstring += String.format(CURRENCY_PARAM, join(currencyCodes));
		}
		URL url = null;
		try {
			url = new URL(urlstring);
		} catch (MalformedURLException ex) {
			System.err.println("Invalid URL: "+urlstring);
			return "";
		}
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		int respcode = conn.getResponseCode();
		if (respcode != HttpURLConnection.HTTP_OK) {
			System.err.println("Got HTTP Response code: "+respcode);
			return "";
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader( conn.getInputStream() ) );
		StringBuilder sb = new StringBuilder();
		String line = null;
		while((line=reader.readLine()) != null) sb.append(line);
		reader.close();
		return sb.toString();
	}
	
	public static String join(String []strings) {
		return java.util.Arrays.stream(strings).collect(Collectors.joining(","));
	}
	
	public static double parseRate(String currencyCode, String data) {
		String regex = String.format("\"USD%s\":\\s*(\\d*.\\d+)", currencyCode);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(data);
		if (! matcher.find() ) {
			return -1.0;
		}
		String value = matcher.group(1);
		try {
			return Double.parseDouble(value);
		} 
		catch(NumberFormatException nfe) {
			return -1.0;
		}
	}	

}
