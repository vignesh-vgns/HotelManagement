package com.vgns.dao;

import com.vgns.dbutil.DBUtil;
import com.vgns.pojo.LoginInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GuestManagementDAO {
    public static int addGuest(LoginInfo guest)    //add new guest into db
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps= conn.prepareStatement("INSERT INTO login(name,mail,mobile,address,password) VALUES(?,?,?,?,?)");
            ps.setString(1,guest.getUserName());
            ps.setString(2, guest.getMail());
            ps.setString(3, guest.getMobile());
            ps.setString(4, guest.getAddress());
            ps.setString(5, guest.getPassword());
            status = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }


    public static int updateGuest(LoginInfo guest)     //edit the existing room details
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps= conn.prepareStatement("UPDATE login SET mail =?, mobile=? , address =?, password=? WHERE name=?");
            ps.setString(1, guest.getMail());
            ps.setString(2, guest.getMobile());
            ps.setString(3, guest.getAddress());
            ps.setString(4, guest.getPassword());
            ps.setString(5, guest.getUserName());

            status = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }


    public static int deleteRoom(String name)     //delete the specific room detail
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps= conn.prepareStatement("DELETE FROM login WHERE name=?");
            ps.setString(1 , name);
            status = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }

    public static List<LoginInfo> getAllGuest()     //method to get all rooms available
    {
        List<LoginInfo> guestList = new ArrayList<>();
        try
        {
            Connection conn = DBUtil.getConnection();    //Get connected to DB
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM login;");
            while(rs.next())
            {
                LoginInfo guest = new LoginInfo(rs.getString("name"),rs.getString("mail"),rs.getString("mobile"),rs.getString("address"),rs.getString("password"));
                guestList.add(guest);
            }

            DBUtil.closeConnection(conn);     //closing DB connection

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return guestList;
    }

    public static LoginInfo getGuestByname(String name)  //get room details by room ID
    {
        LoginInfo guest = null;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM login WHERE name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                guest = new LoginInfo(rs.getString("name"),rs.getString("mail"),rs.getString("mobile"),rs.getString("address"),rs.getString("password"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return guest;

    }
}
