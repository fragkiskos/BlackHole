package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LanguageParsing {
	
	
	
	
	public static  String getValue(String key){
		BufferedReader br = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    String propertiesFilePath=classLoader.getResource("languages/greek.properties").getPath();
		System.out.println(propertiesFilePath);
	    try {
 
			String sCurrentLine;
			br = new BufferedReader(new FileReader(propertiesFilePath));
 
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				String curKey = sCurrentLine.split("=")[0];
				String value = sCurrentLine.split("=")[1];
				if(curKey.equals(key)){
					return value;
				}
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
 
		return null;
	}
	
	
}
