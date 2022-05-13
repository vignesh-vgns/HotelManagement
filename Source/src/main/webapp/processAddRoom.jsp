<%@page import="com.vgns.dao.RoomManagementDAO"%>
<%@page import="com.vgns.pojo.Room"%>
<%@ page import="com.sun.xml.internal.ws.api.client.SelectOptimalEncodingFeature" %>
<%

String FloorNumber = request.getParameter("FloorNumber");
String RoomType = request.getParameter("RoomType");
String AvailDate = request.getParameter("AvailDate");
Integer PricePerDay = Integer.parseInt(request.getParameter("PricePerDay"));

//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//Date AvailDate = dateFormat.parse(d);


Room Room = new Room(FloorNumber,RoomType,AvailDate,PricePerDay);

int status = RoomManagementDAO.addRoom(Room);
if(status == 1)
{
	response.sendRedirect("viewRooms.jsp");
}
else
{
	response.sendRedirect("error.jsp");
}

%>