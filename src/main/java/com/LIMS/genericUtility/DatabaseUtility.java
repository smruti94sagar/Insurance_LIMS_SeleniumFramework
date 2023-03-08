package com.LIMS.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author smruti
 *
 */

public class DatabaseUtility {
	
	Connection connection;
	Statement statement;
	/**
	 * 
	 * @param dBUrl
	 * @param dbUserName
	 * @param dbPassword
	 */
	
public DatabaseUtility(String dBUrl,String dbUserName,String dbPassword)
{
	 Driver d;
	try {
        d = new Driver();
        DriverManager.registerDriver(d);
   	    connection=DriverManager.getConnection(dBUrl,dbUserName,dbPassword);
   	    statement=connection.createStatement();
   	   } catch (SQLException e) 
	   {
          e.printStackTrace();
	   }
}
	/**
	 * 
	 * @param query
	 * @param columnName
	 * @return
	 */
	
	public ArrayList<String> getDataFromDataBase(String query,String columnName)
	{
       ArrayList<String> list=new ArrayList<>();
       try {
		ResultSet result=statement.executeQuery(query);
		while(result.next())
		{
			list.add(result.getString(columnName));
		}
	} 
       catch (SQLException e) 
       {
		
		e.printStackTrace();
       }
	return list;
       
	}	
	/**
	 * 
	 * @param query
	 * @param colName
	 * @param expectedData
	 * @return
	 */
	
	public boolean validateofdataBase(String query,String colName,String expectedData)
	{
		ArrayList<String> list=getDataFromDataBase(query,colName);
		boolean flag=false;
		for(String actaulData:list)
		{
			flag=true;
			break;
		}
		return flag;
		
		
	}
	
	/**
	 * 
	 * @param query
	 */
	
	public void setDataInDataBase(String query)
	{
		try {
			int result=statement.executeUpdate(query);
			if(result>=1)
			{
				System.out.println("Data entered successfully");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * this method is uesd to close the connection
	 */

  public void closeDBConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
		   e.printStackTrace();
		   System.out.println(e.getMessage());
		   System.out.println("While closing the Database connection we got exception");
		}
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 


