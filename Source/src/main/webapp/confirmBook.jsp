<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.vgns.pojo.Room" %>
<%@ page import="com.vgns.dao.RoomManagementDAO" %><%--
  Created by IntelliJ IDEA.
  User: Binary Computer
  Date: 20-May-2022
  Time: 01:40 AM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Check</title>
</head>
<body>
<%@ include file="header.jsp" %>
<form action="Addbook" method="post">

    <label>Name </label>
    <input type="text" name="userName" value="<%=userName%>" class="searchTextField"/>

    <label>Room ID </label>
    <input type="text" name="roomId" value="<%=session.getAttribute("roomid")%>" class="searchTextField"/>

    <label>Enter Checkin Date: </label>
    <input type="date" name="checkin" size="25" value="<%=session.getAttribute("checkind")%>" class="searchTextField"/>

    <label>Enter Checkout Date: </label>
    <input type="date" name="checkout" size="25" value="<%=session.getAttribute("checkoutd")%>" class="searchTextField"/>
    <button class="actionBtn">Confirm Booking</button>
</form>

</body>
</html>
