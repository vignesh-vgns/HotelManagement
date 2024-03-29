<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.vgns.dao.RoomManagementDAO"%>
<%@page import="com.vgns.pojo.Room"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<%@ include file="header.jsp" %>

<% if(Objects.equals(userName, "admin"))
{ %>
<nav style="background-color: coral" class="navbar" >
    <ul class="navbar-nav">
        <li style="float:right;margin-right:10px"><a href="addRoom.jsp">Add Room</a></li>
        <li style="float:right;margin-right:10px"><a href="viewRooms.jsp">Manage Room</a></li>
        <li style="float:right;margin-right:10px"><a href="viewGuest.jsp">Manage Guest</a></li>
    </ul>
</nav>
<%}%>
<div align="center">
<h1>Hotel Management System</h1>
    <h2>Search and Manage Rooms</h2>
<label><b>Welcome <%= userName %></b></label>
</div>
<table align="center" class="productTable">
    <thead>
    <tr>
        <th>Room ID</th>
        <th>Floor Number</th>
        <th>Room Type</th>
        <th>AC/Non-AC</th>
        <th>Price Per Day</th>
        <% if(Objects.equals(userName, "admin")) { %>
        <th colspan="2">Actions</th>
        <% }
            if(!Objects.equals(userName, "admin")) {%>
        <th>book here</th>
        <%}%>
    </tr>
    </thead>
    <%
        List<Room> RoomList = RoomManagementDAO.getAllRooms();
        for (Room p : RoomList) {
    %>
    <tr>
        <td><%=p.getroomId()%></td>
        <td><%=p.getFloorNumber()%></td>
        <td><%=p.getRoomType()%></td>
        <td><%=p.getAC()%></td>
        <td><%= p.getPricePerDay() %></td>
        <% if(Objects.equals(userName, "admin")) { %>
        <td><button class="actionBtn" onclick="location.href = 'editRoom.jsp?roomId=<%= p.getroomId()%>';">Edit</button></td>
        <td><button class="actionBtn" onclick="location.href = 'processDeleteRoom.jsp?roomId=<%= p.getroomId()%>';">Delete</button></td>
        <% }
         if(!Objects.equals(userName, "admin")){ %>
        <td><button class="actionBtn" onclick="location.href = 'checkin.jsp?roomid=<%= p.getroomId()%>';">BOOK</button></td>
        <%}%>
    </tr>

    <%
        }
    %>
</table>

</body>
</html>