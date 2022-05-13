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
			Connection conn = DBUtil.getConnection();
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("SELECT * FROM room");
			while(rs.next())
			{
				Room Room = new Room(rs.getString("FloorNumber"),rs.getString("RoomType"),rs.getString("AvailDate"),rs.getInt("PricePerDay"));
				RoomList.add(Room);
			}
			
			DBUtil.closeConnection(conn);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return RoomList;
	}
	
	
	public static List<Room> getRoomById(String FloorNum)
	{
		List<Room> room = new ArrayList<Room>();
		try
		{
			String Query="SELECT * FROM room ";
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement(Query);
//			ps.setString(1, FloorNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("FloorNumber").equals(FloorNum))
					room.add(new Room(rs.getString("FloorNumber"), rs.getString("RoomType"), rs.getString("AvailDate"), rs.getInt("PricePerDay")));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			room=null;
		}
		return room;
	}

	public static List<Room> getRoomByType(String RoomType)
	{
		List<Room> room = new ArrayList<Room>();
		try
		{
			String Query="SELECT * FROM room ";
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement(Query);
//			ps.setString(1, FloorNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("RoomType").equals(RoomType))
					room.add(new Room(rs.getString("FloorNumber"), rs.getString("RoomType"), rs.getString("AvailDate"), rs.getInt("PricePerDay")));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return room;
	}

	public static List<Room> getRoomByDate(String AvailDate)
	{
		List<Room> room = new ArrayList<Room>();
		try
		{
			String Query="SELECT * FROM room ";
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement(Query);
//			ps.setString(1, FloorNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("AvailDate").equals(AvailDate))
					room.add(new Room(rs.getString("FloorNumber"), rs.getString("RoomType"), rs.getString("AvailDate"), rs.getInt("PricePerDay")));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return room;
	}

	public static List<Room> getRoomByPrice(String PricePerDay)
	{
		List<Room> room = new ArrayList<Room>();
		try
		{
			String Query="SELECT * FROM room ";
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement(Query);
//			ps.setString(1, FloorNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("PricePerDay").equals(PricePerDay))
					room.add(new Room(rs.getString("FloorNumber"), rs.getString("RoomType"), rs.getString("AvailDate"), rs.getInt("PricePerDay")));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return room;
	}
	
	
	public static int addRoom(Room Room)
	{
		int status = 0;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("INSERT INTO Room VALUES(?,?,?,?)");
			ps.setString(1, Room.getFloorNumber());
			ps.setString(2, Room.getRoomType());
			ps.setString(3, Room.getAvailDate());
			ps.setInt(4, Room.getPricePerDay());
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static int updateRoom(Room Room)
	{
		int status = 0;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("UPDATE room SET 'RoomType'=? , 'AvailDate'=?, 'PricePerDay'=? WHERE 'FloorNumber'=?");
			ps.setString(1, Room.getRoomType());
			ps.setString(2, Room.getAvailDate());
			ps.setInt(3, Room.getPricePerDay());
			ps.setString(4, Room.getFloorNumber());
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static int deleteRoom(String FloorNumber)
	{
		int status = 0;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("DELETE FROM room where 'FloorNumber' = ?");
			ps.setString(1, FloorNumber);
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
