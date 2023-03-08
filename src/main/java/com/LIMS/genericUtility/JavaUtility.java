package com.LIMS.genericUtility;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.WebElement;


/**
 * 
 * @author smruti
 *
 */

public class JavaUtility {
	
	/**
	 * 
	 * @param boundryvalue
	 * @return
	 */
	public int getRandomNumber(int boundryvalue)
	{

		return new Random().nextInt(boundryvalue);
	}
	/**
	 * 
	 * @param output
	 */

	public void consolePrint(Object output)
	{
		System.out.println(output);
	}
	/**
	 * 
	 * @param monthName
	 * @param pattern
	 * @return
	 */

	public int getMonthNumber(String monthName,String pattern)
	{
		int month=DateTimeFormatter.ofPattern(pattern.toUpperCase())
				.withLocale(Locale.ENGLISH)
				.parse(monthName)
				.get(ChronoField.MONTH_OF_YEAR);
		return month;
	}
	/**
	  * 
	  * @return
	  */
	 
	 public String getSimpleDateFormate() {
		 SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
		 String date=sdf.format(new Date());
		 return date;
	 }
	/**
	 * 
	 * @param s
	 * @param strategy
	 * @return
	 */


	public String[] spilt(String s,String strategy)
	{
		return s.split(strategy);
	}
	/**
	 * 
	 * @param s
	 * @return
	 */

	public String decode(String s)
	{
		return new String(Base64.getDecoder().decode(s.getBytes()));
	}
	/**
	 * 
	 * @param s
	 * @return
	 */

	public String encode(String s)
	{
		return new String(Base64.getEncoder().encode(s.getBytes()));
	}



	public static void main(String[] args) {
		JavaUtility j=new JavaUtility();
		System.out.println(j.encode("admin"));
		System.out.println(j.decode("YWRtaW4="));

	}

}

