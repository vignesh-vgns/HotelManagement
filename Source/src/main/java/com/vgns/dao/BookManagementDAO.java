package com.vgns.dao;

import com.vgns.dbutil.DBUtil;
import com.vgns.pojo.Room;
import com.vgns.pojo.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookManagementDAO {
    public static int addbook(booking book)    //add new book into db
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps= conn.prepareStatement("INSERT INTO booking(cust_name,roomid,checkin,checkout) VALUES(?,?,?,?)");
            ps.setString(1,book.getcust_name());
            ps.setInt(2, book.getroomid());
            ps.setString(3, book.getcheckin());
            ps.setString(4, book.getcheckout());

            status = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }


    public static booking getbookByname(String name)  //get room details by room ID
    {
        booking book =null;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM booking WHERE cust_name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                book = new booking(rs.getString("cust_name"),rs.getInt("roomid"),rs.getString("checkin"),rs.getString("checkout"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return book;

    }

    public static booking getbookByroom(int roomid)  //get room details by room ID
    {
        booking book =null;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM booking WHERE roomid = ?");
            ps.setInt(1, roomid);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                book = new booking(rs.getString("cust_name"),rs.getInt("roomid"),rs.getString("checkin"),rs.getString("checkout"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return book;

    }
    public static List<booking> getAllbooks()     //method to get all rooms available
    {
        List<booking> bookList = new ArrayList<booking>();
        try
        {
            Connection conn = DBUtil.getConnection();    //Get connected to DB
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM booking;");
            while(rs.next())
            {
                booking book = new booking(rs.getString("cust_name"),rs.getInt("roomid"),rs.getString("checkin"),rs.getString("checkout"));
                bookList.add(book);
            }

            DBUtil.closeConnection(conn);     //closing DB connection

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return bookList;
    }
    public static int deletebook(booking book) {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps= conn.prepareStatement("DELETE FROM booking WHERE cust_name = ?");
            ps.setString(1 ,book.getcust_name());
            status = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }


    public static List<String> validroom(Integer roomid){
        List<String> checklist = new ArrayList<String>();

        try
        {
            Connection conn = DBUtil.getConnection();    //Get connected to DB
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM booking where roomid =?");
            ps.setInt(1,roomid);
            ResultSet rs= ps.executeQuery();

            if(rs.next())
            {
               checklist.add(rs.getString("checkin"));
            }

            DBUtil.closeConnection(conn);     //closing DB connection

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return checklist;
    }
    public static List<String> validroom2(Integer roomid){
        List<String> checklist = new ArrayList<String>();

        try
        {
            Connection conn = DBUtil.getConnection();    //Get connected to DB
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM booking where roomid =?");
            ps.setInt(1,roomid);
            ResultSet rs= ps.executeQuery();

            if(rs.next())
            {
                checklist.add(rs.getString("checkout"));
            }

            DBUtil.closeConnection(conn);     //closing DB connection

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return checklist;
    }
    public static int compareDates(String d1,String d2,String d3,String d4)
    { int status=0;
        try{
            // If you already have date objects then skip 1

            //1
            // Create 2 dates starts
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = sdf.parse(d1);
            Date date2 = sdf.parse(d2);
            Date date3 = sdf.parse(d3);
            Date date4 = sdf.parse(d4);

            System.out.println("Date1"+sdf.format(date1));
            System.out.println("Date2"+sdf.format(date2));System.out.println();

            // Create 2 dates ends
            //1

            // Date object is having 3 methods namely after,before and equals for comparing
            // after() will return true if and only if date1 is after date 2
            if(date1.after(date4)){
                status=1;
            }
            // before() will return true if and only if date1 is before date2
            else if(date1.before(date4)){
                if(date1.before(date3) && date2.before(date3)){
                    status=1;
                }
            }

            //equals() returns true if both the dates are equal
            else if(date1.equals(date3)){
                status=0;
            }

            System.out.println();
        }
        catch(ParseException ex){
            ex.printStackTrace();
        }
        return status;
    }
}
