package first;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.*;

import com.mysql.jdbc.Driver;
public class Database2 {
	
	@Test
	public void create() throws SQLException
	{
		
		String expectedname="snehal";
		boolean flag=false;
		  Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			System.out.println("done");
			
			Statement stmt=con.createStatement();
			//select query
		  ResultSet result=stmt.executeQuery("select * from STUDENT");
	     	while(result.next())
		   {
	     		String name=result.getString(2);
	     		if(expectedname.equals(name))
	     		{
	     			flag=true;
			    //System.out.println(result.getString(1)+"\t"+result.getString(2));
	     			System.out.println(expectedname+"is  available ====fail");
		       }
		   }
	     	
	     	if(flag==false)
	     	{
	     		System.out.println("is not available ====fail");
	     		Assert.fail();
	     	}
         con.close();
	}

}
