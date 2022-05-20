<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.vgns.dao.RoomManagementDAO"%>
<%@page import="com.vgns.pojo.Room"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Room</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<%
		Integer RoomId = Integer.parseInt(request.getParameter("roomId"));
		Room room = RoomManagementDAO.getRoomById(RoomId);
		
	%>
	<div align="center">
		<form action="EditServlet" method="post">
			<table class="productTable">
				<thead>
					<tr>
						<th colspan="2">
							Room Details
						</th>
					</tr>
				</thead>
				<tr>
					<td>Room Id</td>
					<td><input type="text" name="roomId" size="20"
							   value="<%=room.getroomId()%>" class="productTextField"/></td>
				</tr>
				<tr>
					<td>Floor Number</td>
					<td><input type="text" name="FloorNumber" size="20"
						value="<%=room.getFloorNumber()%>" class="productTextField"/></td>
				</tr>
				<tr>
					<td>Room Type</td>
					<td><input type="text" name="RoomType" size="20"
						value="<%=room.getRoomType()%>" class="productTextField"/></td>
				</tr>
				<tr>
					<td>AC/Non-AC</td>
					<td><input type="text" name="AC" size="20"
						value="<%=room.getAC()%>" class="productTextField"/></td>
				</tr>
				<tr>
					<td>Price Per Day</td>
					<td><input type="text" name="PricePerDay" size="20"
						value="<%=room.getPricePerDay()%>" class="productTextField"/></td>
				</tr>
			</table>
			<button class="actionBtn" style="margin-top:10px">Save</button>
		</form>
	</div>
</body>
</html>