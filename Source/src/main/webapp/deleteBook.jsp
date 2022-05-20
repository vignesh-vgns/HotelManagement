<%@page import="com.vgns.dao.RoomManagementDAO"%>
<%@page import="com.vgns.pojo.Room"%>
<%@ page import="com.vgns.dao.BookManagementDAO" %>
<%@ page import="com.vgns.pojo.booking" %>

<%

    int roomid= Integer.parseInt(request.getParameter("roomid"));
    booking book = BookManagementDAO.getbookByroom(roomid);
    int status = BookManagementDAO.deletebook(book);

    if(status == 1)
    {
        response.sendRedirect("viewBooks.jsp");
    }
    else
    {
        response.sendRedirect("error.jsp");
    }

%>