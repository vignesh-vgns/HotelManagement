<%@page import="com.vgns.dao.RoomManagementDAO"%>
<%@page import="com.vgns.pojo.Room"%>

<%

    Integer roomId = Integer.parseInt(request.getParameter("roomId"));
    Room room= RoomManagementDAO.getRoomById(roomId);
    int status1= RoomManagementDAO.addBook(room);
    int status = RoomManagementDAO.deleteRoom(roomId);
    if(status == 1 && status1==1)
    {
        response.sendRedirect("viewRooms.jsp");
    }
    else
    {
        response.sendRedirect("error.jsp");
    }

%>