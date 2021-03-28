package dao;
import java.sql.*;
public class ConnectionProvider 
{
	private ConnectionProvider()
	{
		
	}
	public static Connection getCon()
	{
		try
		{
			
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Swathi");
			
		}
		 catch(Exception e)
		{
			 
			 e.printStackTrace();
			 return null;
			 
		}
	
		
	}

}
