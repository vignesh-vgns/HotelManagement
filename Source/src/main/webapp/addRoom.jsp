<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Room</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<div align="center">
		<form action="AddServlet" method="post">
			<table class="productTable">
				<thead>
					<tr>
						<th colspan="2">
							Room Details
						</th>
					</tr>
				</thead>
				<tr>
					<td>Room ID</td>
					<td><input type="text" name="roomId" size="20"
							   class="productTextField" /></td>
				</tr>
				<tr>
					<td>Floor Number</td>
					<td><input type="text" name="FloorNumber" size="20"
						class="productTextField" /></td>
				</tr>
				<tr>
					<td>Room Type</td>
					<td>
						<label>
							<select name="RoomType" class="productTextField">
								<option value="standard">standard</option>
								<option value="deluxe">deluxe</option>
								<option value="family suite">family suite</option>
								<option value="Quad Bedroom">Quad Bedroom</option>
							</select>
						</label>
					</td>
				</tr>
				<tr>
					<td>AC/Non-AC</td>
					<td><input type="text" name="AC" size="20"
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