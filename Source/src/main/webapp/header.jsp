<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<%
	if(session.getAttribute("userName") == null)
	{
		response.sendRedirect("index.jsp");
	}
	%>
	<nav class="navbar">
		<ul class="navbar-nav">
			<li><a href="home.jsp">Home</a></li>
			<% if(Objects.equals((String)session.getAttribute("userName"), "admin"))
			{
			%>
			<li><a href="addRoom.jsp">Add Room</a></li>
			<%}%>
			<li><a href="viewRooms.jsp">View Rooms</a></li>
			<li><a href="searchRoom.jsp">Search Rooms</a></li>
			<li><a href="viewBooks.jsp">Bookings</a></li>
			<li style="float:right;margin-right:10px"><a href="logout.jsp">Logout</a></li>
		</ul>
	</nav>
</body>
</html>