package com.libraryct.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	
	private static Properties prop;
	
	public static void readProperties(String path) {
		
		try {
			FileInputStream file=new FileInputStream(path);
			prop=new Properties();
			prop.load(file);
			file.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	
public static String getProperty(String key)	{
	return prop.getProperty(key);
}
	

}
