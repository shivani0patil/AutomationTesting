package first;
import java.sql.*;

import com.mysql.jdbc.Driver;
public class Database3 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
      
		Connection con=null;
		try
		{
	    Driver driver=new Driver();
		DriverManager.registerDriver(driver);
	     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		System.out.println("done");
		Statement stmt=con.createStatement();
		//select query
	ResultSet result=stmt.executeQuery("select * from STUDENT");
	
			while(result.next())
			{
				System.out.println(result.getString(1)+"\t"+result.getString(2));
			}
				
				
				//non select query
				
//				int result=stmt.executeUpdate("insert into STUDENT values('107','ritik')");
//				System.out.println(result);
			
		}catch(Exception e)
		{
			System.out.println("handle nay exception");
		}
			finally
			{
				con.close();
			}
	}

}
