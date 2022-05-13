<%@page import="com.vgns.dao.RoomManagementDAO"%>
<%@page import="com.vgns.pojo.Room"%>

<%

String floor_no = request.getParameter("FloorNumber");

int status = RoomManagementDAO.deleteRoom(floor_no);
if(status == 1)
{
	response.sendRedirect("viewRooms.jsp"); 
}
else
{
	response.sendRedirect("error.jsp"); 
}

%>