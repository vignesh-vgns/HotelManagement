package com.vgns.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.vgns.dbutil.DBUtil;
import com.vgns.pojo.LoginInfo;

public class LoginDAO {
	public static boolean isUserValid(LoginInfo userDetails)   //validate the user details from user table
	{
		boolean validStatus = false;
		try
		{
			Connection conn = DBUtil.getConnection();
			ResultSet rs;
			Statement st = conn.createStatement();
				rs = st.executeQuery("SELECT * FROM login WHERE name = '" + userDetails.getUserName() + "' AND password = '" + userDetails.getPassword() + "'");

			while(rs.next())
			{
				validStatus = true;
			}
			
			DBUtil.closeConnection(conn);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return validStatus;
	}
}
