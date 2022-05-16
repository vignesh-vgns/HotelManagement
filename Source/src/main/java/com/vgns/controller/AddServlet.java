package com.vgns.controller;
import com.vgns.dao.RoomManagementDAO;
import com.vgns.pojo.Room;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer roomId = Integer.parseInt(request.getParameter("roomId"));
        String FloorNumber = request.getParameter("FloorNumber");
        String RoomType = request.getParameter("RoomType");
        String AvailDate =request.getParameter("AvailDate");
        Integer PricePerDay = Integer.parseInt(request.getParameter("PricePerDay"));


        Room Room = new Room(roomId,FloorNumber,RoomType,AvailDate,PricePerDay);

        int status = RoomManagementDAO.addRoom(Room);

        if(status == 1)
        {
            response.sendRedirect("viewRooms.jsp");
        }
        else
        {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
