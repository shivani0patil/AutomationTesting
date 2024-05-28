package com.crm.generic.Databse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertFile {

		

		
		public String getDataProperty(String Key) throws Throwable
		{
			FileInputStream fs=new FileInputStream("./src/test/resources/comm.properties");
            Properties op=new Properties();
            op.load(fs);
            String data =op.getProperty(Key);
            return data;
		}
	

}
