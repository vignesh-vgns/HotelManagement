<%@page import="com.vgns.dao.RoomManagementDAO"%>
<%@page import="com.vgns.pojo.Room"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>

<%
	String FloorNumber = request.getParameter("FloorNumber");
	String RoomType = request.getParameter("RoomType");
	String AvailDate=request.getParameter("AvailDate");
	Integer PricePerDay = Integer.parseInt(request.getParameter("PricePerDay"));

	Room Room = new Room(FloorNumber,RoomType,AvailDate,PricePerDay);

int status = RoomManagementDAO.updateRoom(Room);
if(status == 1)
{
	response.sendRedirect("viewRooms.jsp"); 
}
else
{
	response.sendRedirect("error.jsp"); 
}

%>