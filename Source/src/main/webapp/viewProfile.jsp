<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.vgns.dao.GuestManagementDAO" %>
<%@ page import="com.vgns.pojo.LoginInfo" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>profile</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%
    LoginInfo guest = GuestManagementDAO.getGuestByname(userName);

%>
<div align="center">

        <table class="productTable">
            <thead>
            <tr>
                <th colspan="2">
                    Your updated Details
                </th>
            </tr>
            </thead>
            <tr>
                <td>name</td>
                <td><input type="text" name="roomId" size="20"
                           value="<%=guest.getUserName()%>" class="productTextField"/></td>
            </tr>
            <tr>
                <td>Mail ID</td>
                <td><input type="text" name="mail" size="20"
                           value="<%=guest.getMail()%>" class="productTextField"/></td>
            </tr>
            <tr>
                <td>Mobile</td>
                <td><input type="text" name="mobile" size="20"
                           value="<%=guest.getMobile()%>" class="productTextField"/></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" size="20"
                           value="<%=guest.getAddress()%>" class="productTextField"/></td>
            </tr>
            <tr>
                <td>password</td>
                <td><input type="password" name="password" size="20"
                           value="<%=guest.getPassword()%>" class="productTextField"/></td>
            </tr>
        </table>
        <button class="actionBtn" onclick="location.href = 'editGuest.jsp?name=<%= guest.getUserName()%>';" style="margin-top:10px">Edit</button>

</div>
</body>
</html>