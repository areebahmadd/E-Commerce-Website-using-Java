package com.project;
import java.sql.*;

public class ConnectionProvider {
	public static Connection getCon() {
		try 
		{
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			
			return connection;
		
		}
		
		catch(Exception e)
		{
			//System.out.print(e.printStackTrace());
			return null;
		}
}
}
