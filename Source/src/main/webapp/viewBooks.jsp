<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="com.vgns.dao.RoomManagementDAO"%>
<%@page import="com.vgns.pojo.Room"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>View Rooms</title>
</head>
<body>
<%@ include file="header.jsp" %>

<table align="center" class="productTable">
  <thead>
  <tr>
    <th>Room ID</th>
    <th>Floor Number</th>
    <th>Room Type</th>
    <th>checkin Date</th>
    <th>Minimum Price</th>
    <th colspan="2">Actions</th>

  </tr>
  </thead>
  <%
    List<Room> RoomList = RoomManagementDAO.getAllBooks();
    for (Room p : RoomList) {
  %>
  <tr>
    <td><%=p.getroomId()%></td>
    <td><%=p.getFloorNumber()%></td>
    <td><%=p.getRoomType()%></td>
    <td><%=p.getAvailDate()%></td>
    <td><%= p.getPricePerDay() %></td>
    <td><button class="actionBtn" onclick="location.href = 'editRoom.jsp?roomId=<%= p.getroomId()%>';">Edit</button></td>
    <td><button class="actionBtn" onclick="location.href = 'deleteBook.jsp?roomId=<%= p.getroomId()%>';">Remove Book</button></td>

  </tr>
  <%
    }
  %>
</table>

</body>
</html>
