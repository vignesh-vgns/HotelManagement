<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@ page import="com.vgns.pojo.LoginInfo" %>
<%@ page import="com.vgns.dao.GuestManagementDAO" %>
<%@ page import="javax.swing.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Guests</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div align="center" style="padding-top:25px;">
    <form action="viewGuest.jsp">
        <label>Enter name</label>
        <input type="text" name="name" size="25" class="searchTextField"/>
        <button class="actionBtn">Search</button>
    </form>
</div>
<table align="center" class="productTable"e>
    <thead>
    <tr>
        <th>Name</th>
        <th>Mail ID</th>
        <th>Mobile Number</th>
        <th>Address</th>
        <th>password</th>
        <th colspan="2">Actions</th>
    </tr>
    </thead>
<%
    String name = request.getParameter("name");
    if(name != null) {
        LoginInfo guest = GuestManagementDAO.getGuestByname(name);
        %>
<tr>

    <td><%=guest.getUserName()%></td>
    <td><%=guest.getMail()%></td>
    <td><%=guest.getMobile()%></td>
    <td><%=guest.getAddress()%></td>
    <td><%= guest.getPassword() %></td>
    <td><button class="actionBtn" onclick="location.href = 'editGuest.jsp?name=<%= guest.getUserName()%>';">Edit</button></td>
    <td><button class="actionBtn" onclick="location.href = 'processDeleteGuest.jsp?name=<%= guest.getUserName()%>';">Delete</button></td>
</tr>
<%
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
<h2 align="center">All Guests</h2>
<table align="center" class="productTable">
    <thead>
    <tr>
        <th>Name</th>
        <th>Mail ID</th>
        <th>Mobile Number</th>
        <th>Address</th>
        <th>password</th>
        <th colspan="2">Actions</th>
    </tr>
    </thead>
    <%
        List<LoginInfo> guestList = GuestManagementDAO.getAllGuest();
        for (LoginInfo g : guestList) {
    %>
    <tr>
        <td><%=g.getUserName()%></td>
        <td><%=g.getMail()%></td>
        <td><%=g.getMobile()%></td>
        <td><%=g.getAddress()%></td>
        <td><%= g.getPassword() %></td>
        <td><button class="actionBtn" onclick="location.href = 'editGuest.jsp?name=<%= g.getUserName()%>';">Edit</button></td>
        <td><button class="actionBtn" onclick="location.href = 'processDeleteGuest.jsp?name=<%= g.getUserName()%>';">Delete</button></td>
    </tr>
    <%
        }
    %>
</table>
<div align="center">
    <button  class="actionBtn" onclick="location.href = 'register.jsp'">Add Guest</button>
</div>
</body>
</html>