
<%@ page import="com.vgns.dao.GuestManagementDAO" %>

<%

    String name = request.getParameter("name");

    int status = GuestManagementDAO.deleteRoom(name);
    if(status == 1)
    {
        response.sendRedirect("viewGuest.jsp");
    }
    else
    {
        response.sendRedirect("error.jsp");
    }

%>