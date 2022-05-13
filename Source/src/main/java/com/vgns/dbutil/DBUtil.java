package com.vgns.dbutil;

import java.sql.*;

public class DBUtil {

//    private String jdbcURL = "org.postgresql.Driver";
//    private String DB_URL ="jdbc:postgresql://localhost/users";
//    private String jdbcUsername = "postgres";
//    private String jdbcPassword = "1901257";
	public static Connection getConnection()
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
	
	
	public static void closeConnection(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
