package com.vgns.controller;

import com.vgns.dao.GuestManagementDAO;
import com.vgns.dao.RoomManagementDAO;
import com.vgns.pojo.LoginInfo;
import com.vgns.pojo.Room;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/EditGuest")
public class EditGuest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
       LoginInfo guest = null;
       guest = new LoginInfo(name, mail, mobile, address, password);

        int status = GuestManagementDAO.updateGuest(guest);

        if (status == 1) {
            response.sendRedirect("viewProfile.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
