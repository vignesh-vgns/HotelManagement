<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ page import="com.vgns.pojo.booking" %>
<%@ page import="com.vgns.dao.BookManagementDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
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
        <th>Name</th>
        <th>room ID</th>
        <th>checkin Date</th>
        <th>checkout Date</th>
        <th colspan="2">Actions</th>

    </tr>
    </thead>
    <%
        List<booking> booklist = BookManagementDAO.getAllbooks();
        System.out.println(userName);
        if(booklist != null)
        {
            for(booking book: booklist)
            {
                if(Objects.equals(book.getcust_name(), userName))
                {
    %>
    <tr>
        <td><%=book.getcust_name()%></td>
        <td><%=book.getroomid()%></td>
        <td><%=book.getcheckin()%></td>
        <td><%=book.getcheckout()%></td>

        <td><button class="actionBtn" onclick="location.href = 'editBook.jsp?name=<%= book.getroomid()%>';">Edit</button></td>
        <td><button class="actionBtn" onclick="location.href = 'deleteBook.jsp?name=<%= book.getroomid()%>';">Remove Book</button></td>

    </tr>
    <%
            }
        }
    }
    else
    {
    %>
    <tr>
        <td colspan="5">No record to display</td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
