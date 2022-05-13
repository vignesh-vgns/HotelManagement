package com.vgns.pojo;


public class Room {

	String floorNumber;
	String roomType;
	String availDate;
	Integer pricePerDay;

//creating constructor
	public Room(String floorNumber, String roomType, String availDate, Integer pricePerDay) {
		super();
		this.floorNumber = floorNumber;
		this.roomType = roomType;
		this.availDate = availDate;
		this.pricePerDay = pricePerDay;
	}

	//getter and setter methods
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

	public String getAvailDate() {
		return availDate;
	}

	public void setAvailDate(String availDate) {
		this.availDate = availDate;
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
				+ availDate + ", pricePerDay=" + pricePerDay + "]";
	}

    
}
