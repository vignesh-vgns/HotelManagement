<%@page import="com.vgns.dao.RoomManagementDAO"%>
<%@page import="com.vgns.pojo.Room"%>


<%
	Integer roomId = Integer.parseInt(request.getParameter("roomId"));
	String FloorNumber = request.getParameter("FloorNumber");
	String RoomType = request.getParameter("RoomType");
	String AvailDate=request.getParameter("AvailDate");
	Integer PricePerDay = Integer.parseInt(request.getParameter("PricePerDay"));

	Room Room = new Room(roomId,FloorNumber,RoomType,AvailDate,PricePerDay);

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