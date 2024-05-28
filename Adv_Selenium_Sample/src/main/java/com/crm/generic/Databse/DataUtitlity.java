package com.crm.generic.Databse;
import com.mysql.jdbc.Driver;
import java.sql.*;

public class DataUtitlity {
	
	Connection con;
	public void getdbConnection(String url,String user,String pass)
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(url, user, pass);
			
		}catch(Exception e) {}
	}

	public void getdbConnection()
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:/mysql://localhost://3306/test", "root", "root");
			
		}catch(Exception e) {}
	}
	public void getCloseConnection()
	{
		try {
			con.close();
			
		}catch(Exception e) {}
	}
	public ResultSet getExcuteQuery(String query)
	{
		ResultSet result=null;
		try {
			Statement stmt=con.createStatement();
			result=stmt.executeQuery(query);
			
		}catch(Exception e) {}
		return result;
	}
	public int getUpdateQuery(String query)
	{
		int result=0;
		try {
			Statement stmt=con.createStatement();
			result=stmt.executeUpdate(query);
			
		}catch(Exception e) {}
		return result;
	}
}
