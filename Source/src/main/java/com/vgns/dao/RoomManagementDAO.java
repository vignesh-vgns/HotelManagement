package com.vgns.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.vgns.dbutil.DBUtil;
import com.vgns.pojo.Room;

public class RoomManagementDAO {
	public static List<Room> getAllRooms()     //method to get all rooms available
	{
		List<Room> RoomList = new ArrayList<Room>();
		try
		{
			Connection conn = DBUtil.getConnection();    //Get connected to DB
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("SELECT * FROM room;");
			while(rs.next())
			{
				Room Room = new Room(rs.getInt("roomId"),rs.getString("FloorNumber"),rs.getString("RoomType"),rs.getString("AvailDate"),rs.getInt("PricePerDay"));
				RoomList.add(Room);
			}
			
			DBUtil.closeConnection(conn);     //closing DB connection
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return RoomList;
	}

	public static Room getRoomById(Integer roomId)  //get room details by room ID
	{
			Room room = null;
			try
			{
				Connection conn = DBUtil.getConnection();
				PreparedStatement ps= conn.prepareStatement("SELECT * FROM room WHERE roomid = ?");
		 		ps.setInt(1, roomId);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					room = new Room(rs.getInt("roomId"),rs.getString("floorNumber"),rs.getString("RoomType"),rs.getString("AvailDate"),rs.getInt("PricePerDay"));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			return room;

	}
	public static Room getBookById(Integer roomId)  //get room details by room ID
	{
		Room room = null;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("SELECT * FROM books WHERE roomid = ?");
			ps.setInt(1, roomId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				room = new Room(rs.getInt("roomId"),rs.getString("floorNumber"),rs.getString("RoomType"),rs.getString("AvailDate"),rs.getInt("PricePerDay"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return room;

	}
	public static List<Room> getRoomByFloorNum(String FloorNum)   //To get all the rooms having the specific Floor number
	{
		List<Room> room = new ArrayList<Room>();
		try
		{
			String Query="SELECT * FROM room";
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement(Query);
//			ps.setString(1, FloorNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("FloorNumber").equals(FloorNum))
					room.add(new Room(rs.getInt("roomId"),rs.getString("FloorNumber"), rs.getString("RoomType"), rs.getString("AvailDate"), rs.getInt("PricePerDay")));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			room=null;
		}
		return room;
	}

	public static List<Room> getRoomByType(String RoomType)   //To get all the rooms having the specific Room Type
	{
		List<Room> room = new ArrayList<Room>();
		try
		{
			String Query="SELECT * FROM room";
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement(Query);
//			ps.setString(1, FloorNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("RoomType").equals(RoomType))
					room.add(new Room(rs.getInt("roomId"),rs.getString("FloorNumber"), rs.getString("RoomType"), rs.getString("AvailDate"), rs.getInt("PricePerDay")));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return room;
	}

	public static List<Room> getRoomByDate(String AvailDate)    //To get all the rooms with same available date
	{
		List<Room> room = new ArrayList<Room>();
		try
		{
			String Query="SELECT * FROM room";
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement(Query);
//			ps.setString(1, FloorNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("AvailDate").equals(AvailDate))
					room.add(new Room(rs.getInt("roomId"),rs.getString("FloorNumber"), rs.getString("RoomType"), rs.getString("AvailDate"), rs.getInt("PricePerDay")));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return room;
	}

	public static List<Room> getRoomByPrice(String PricePerDay)    //To get all the rooms having the specific price
	{
		List<Room> room = new ArrayList<Room>();
		try
		{
			String Query="SELECT * FROM room";
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement(Query);
//			ps.setString(1, FloorNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("PricePerDay").equals(PricePerDay))
					room.add(new Room(rs.getInt("roomId"),rs.getString("FloorNumber"), rs.getString("RoomType"), rs.getString("AvailDate"), rs.getInt("PricePerDay")));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return room;
	}
	
	
	public static int addRoom(Room Room)    //add new room into db
	{
		int status = 0;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("INSERT INTO Room(roomid,floornumber,roomtype,availdate,priceperday) VALUES(?,?,?,?,?)");
			ps.setInt(1,Room.getroomId());
			ps.setString(2, Room.getFloorNumber());
			ps.setString(3, Room.getRoomType());
			ps.setString(4, Room.getAC());
			ps.setInt(5, Room.getPricePerDay());
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static int updateRoom(Room Room)     //edit the existing room details
	{
		int status = 0;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("UPDATE room SET roomid =?, floornumber =?, roomtype=? , availdate =?, PricePerDay=? WHERE roomid=?");
			ps.setInt(1 ,Room.getroomId());
			ps.setString(2, Room.getFloorNumber());
			ps.setString(3, Room.getRoomType());
			ps.setString(4, Room.getAC());
			ps.setInt(5, Room.getPricePerDay());
			ps.setInt(6 ,Room.getroomId());
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static int deleteRoom(Integer FNumber)     //delete the specific room detail
	{
		int status = 0;
		try
		{
			System.out.println(FNumber);
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("DELETE FROM room WHERE roomid=?");
			ps.setInt(1 , FNumber);
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	public static List<Room> getAllBooks() {
		List<Room> RoomList = new ArrayList<Room>();
		try
		{
			Connection conn = DBUtil.getConnection();    //Get connected to DB
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("SELECT * FROM books;");
			while(rs.next())
			{
				Room Room = new Room(rs.getInt("roomId"),rs.getString("FloorNumber"),rs.getString("RoomType"),rs.getString("AvailDate"),rs.getInt("PricePerDay"));
				RoomList.add(Room);
			}

			DBUtil.closeConnection(conn);     //closing DB connection

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return RoomList;
	}

	public static int deleteBook(int FNumber)     //delete the specific room detail
	{
		int status = 0;
		try
		{
			System.out.println(FNumber);
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("DELETE FROM books WHERE roomid = ?");
			ps.setInt(1 , FNumber);
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
