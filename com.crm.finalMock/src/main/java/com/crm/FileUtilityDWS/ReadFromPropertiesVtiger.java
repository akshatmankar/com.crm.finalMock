package com.crm.FileUtilityDWS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesVtiger {

	public static String getData(String key) throws IOException {
		   Properties prop=new Properties();
		   FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\DataLoginVtiger");
		   prop.load(fis);
		   String data = prop.getProperty(key);
		   return data;
	}

}
