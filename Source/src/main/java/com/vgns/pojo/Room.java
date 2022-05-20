package com.vgns.pojo;


public class Room {
	int roomId;
	String floorNumber;
	String roomType;
	String AC;
	Integer pricePerDay;

    public Room(){
		String roomId;
		String floorNumber;
		String roomType;
		String AC;
		Integer pricePerDay;
	}

	//creating constructor
	public Room(int roomId,String floorNumber, String roomType, String AC, Integer pricePerDay) {
		super();
		this.roomId=roomId;
		this.floorNumber = floorNumber;
		this.roomType = roomType;
		this.AC = AC;
		this.pricePerDay = pricePerDay;
	}

	//getter and setter methods
	public int getroomId() {
		return roomId;
	}

	public void setroomId(Integer roonId) {
		this.roomId = roomId;
	}
	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getAC() {
		return AC ;
	}

	public void setAC(String AC) {
		this.AC = AC;
	}

	public Integer getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Integer pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	@Override
	public String toString() {
		return "room [floorNumber=" + floorNumber + ", roomType=" + roomType + ", availDate="
				+ AC + ", pricePerDay=" + pricePerDay + "]";
	}
}
