package com.LIMS.genericUtility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import com.LIMS.genericUtility.enums.PropertiesFile;



public class CharacteristicUtility {

	private Properties prop;
	/**
	 * 
	 * @param filepath
	 * @throws IOException
	 */
	
	public CharacteristicUtility(String filepath) throws IOException
	{
		FileInputStream fisProperty=new FileInputStream(filepath);
		prop=new Properties();
		prop.load(fisProperty);
		//fisProperty.close();
	}
	/**
	 * this constructor is used to create object for class
	 */
	
	public CharacteristicUtility()
	{
		
	}
	/**
	 * this method is used to intialize Property file
	 * @deprecated new PropertyUtiltly(String filepath)
	 * @param filepath
	 * @throws IOException
	 */
	 @Deprecated
	public void intializePropertyFile(String filepath) throws IOException
	{
		FileInputStream fisProperty=new FileInputStream(filepath);
		prop=new Properties();
		prop.load(fisProperty);
		//fisProperty.close();
	}
	 /**
	  * 
	  * @param key
	  * @return
	  */
	 public String getPropertyData(PropertiesFile  key)
	 {
		 String keyString=key.name().toLowerCase();
		 String value=prop.getProperty(keyString,"please give proper keyu'"+keyString+"'").trim();
		 return value;
	 }
	
	}
	

