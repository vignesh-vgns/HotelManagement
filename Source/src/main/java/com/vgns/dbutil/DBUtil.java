package com.vgns.dbutil;

import java.sql.*;

public class DBUtil {
	public static Connection getConnection()  //method for DB Connection
	{
		Connection conn = null;
		try 
		{
			
			Class.forName("org.postgresql.Driver");
		    conn = DriverManager.getConnection("jdbc:postgresql://localhost/users", "postgres", "1901257");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void closeConnection(Connection conn)   //closing Connection object
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
