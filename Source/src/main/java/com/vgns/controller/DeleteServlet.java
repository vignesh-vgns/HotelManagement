package com.vgns.controller;

import com.vgns.dao.RoomManagementDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer roomId = Integer.parseInt(request.getParameter("roomId"));

        int status = RoomManagementDAO.deleteRoom(roomId);
        if(status == 1)
        {
            response.sendRedirect("viewRooms.jsp");
        }
        else
        {
            response.sendRedirect("error.jsp");
        }
    }
}
