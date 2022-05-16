<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.vgns.dao.RoomManagementDAO"%>
<%@page import="com.vgns.pojo.Room"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Room</title>
</head>
<body>
<%@ include file="header.jsp" %>  
<div align="center" style="padding-top:25px;">
	<form action="searchRoom.jsp">


		<label>Enter Floor Number: </label>
		<input type="text" name="FloorNumber" size="25" class="searchTextField"/>

		<label>Enter Room Type: </label>
		<input type="text" name="RoomType" size="25" class="searchTextField"/>

		<label>Enter Date: (dd-mm-yyyy)</label>
		<input type="text" name="AvailDate" size="25" class="searchTextField"/>

		<label>Enter Price Range: </label>
		<input type="text" name="PricePerDay" size="25" class="searchTextField"/>

		<button class="actionBtn">Search</button>
	</form>
</div> 
	<table align="center" class="productTable">
		<thead>
			<tr>
				<th>Room ID</th>
				<th>Floor Number</th>
				<th>Room Type</th>
				<th>Date Available</th>
				<th>Price Per Day</th>
				<th colspan="2">Actions</th>
			</tr> 
		</thead>
		<%
			List<Room> p = null;
			String floor_no = request.getParameter("FloorNumber");
			String RoomType = request.getParameter("RoomType");
			String AvailDate = request.getParameter("AvailDate");
			String PricePerDay = request.getParameter("PricePerDay");

			if(floor_no != "")
			{
				p = RoomManagementDAO.getRoomByFloorNum(floor_no);
			}
			if( RoomType!="") {
				p = RoomManagementDAO.getRoomByType(RoomType);
			}
			if( AvailDate!="") {
				p = RoomManagementDAO.getRoomByDate(AvailDate);
			}
			if( PricePerDay!=""){
				p = RoomManagementDAO.getRoomByPrice(PricePerDay);
			}
			if (p != null)
			{
				for (Room i: p) {
		%>
		<tr>
			<td><%=i.getroomId()%></td>
			<td><%=i.getFloorNumber()%></td>
			<td><%=i.getRoomType()%></td>
			<td><%=i.getAvailDate()%></td>
			<td><%= i.getPricePerDay() %></td>
			<td><button class="actionBtn" onclick="location.href = 'editRoom.jsp?roomId=<%= i.getroomId()%>';">Edit</button></td>
			<td><button class="actionBtn" onclick="location.href = 'processDeleteRoom.jsp?roomId=<%= i.getroomId()%>';">Delete</button></td>
			<td><button class="actionBtn" onclick="location.href = 'processDeleteRoom.jsp?FloorNumber=<%= i.getFloorNumber()%>';">BOOK</button></td>
		</tr>
		<%
			}
				p=null;
		}
		else{
		%>
		<tr>
				<td colspan="5">No record to display</td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>