<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.vgns.dao.RoomManagementDAO"%>
<%@page import="com.vgns.pojo.Room"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Room</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<div align="center">
		<form action="processAddRoom.jsp" method="post">
			<table class="productTable">
				<thead>
					<tr>
						<th colspan="2">
							Room Details
						</th>
					</tr>
				</thead>
				<tr>
					<td>Floor Number</td>
					<td><input type="text" name="FloorNumber" size="20"
						class="productTextField" /></td>
				</tr>
				<tr>
					<td>Room Type</td>
					<td>
					<select name="RoomType" class="productTextField">
						<option value="standard">standard</option>
						<option value="deluxe">deluxe</option>
						<option value="family suite">family suite</option>
						<option value="Quad Bedroom">Quad Bedroom</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>Available Date(dd-mm-yyyy)</td>
					<td><input type="text" name="AvailDate" size="20"
						class="productTextField" /></td>
				</tr>
				<tr>
					<td>Price Per Day</td>
					<td><input type="text" name="PricePerDay" size="20"
						class="productTextField" /></td>
				</tr>
			</table>
			<button class="actionBtn" style="margin-top:10px">Add</button>
		</form>
	</div>
</body>
</html>