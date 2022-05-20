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

<div align="center" style="padding-top:25px;">
    <form action="Checkin" method="post">
        <label>Room ID</label>
        <input type="text" name="roomid" value="<%=request.getParameter("roomid")%>" size="25" class="searchTextField"/>

        <label>Enter Checkin date</label>
        <input type="date" name="checkind" size="25" class="searchTextField"/>

        <label>Enter Checkout date</label>
        <input type="date" name="checkoutd" size="25" class="searchTextField"/>
        <button class="actionBtn">Check</button>
    </form>
</div>
<h3 align="center">Available Rooms</h3>
<h4 align="center">Click on 'book' for checking availability on your desired days</h4>
<table align="center" class="productTable">
    <thead>
    <tr>
        <th>Room ID</th>
        <th>Floor Number</th>
        <th>Room Type</th>
        <th>AC/Non-AC</th>
        <th>Minimum Price</th>
        <% if(Objects.equals(userName, "admin")) { %>
        <th colspan="2">Actions</th>
        <%}%>
        <th>book here</th>
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
        <% }%>

        <td><button class="actionBtn" onclick="location.href = 'checkin.jsp?roomid=<%= p.getroomId()%>';">BOOK</button></td>

    </tr>
    <%
        }
    %>
</table>

</body>
</html>