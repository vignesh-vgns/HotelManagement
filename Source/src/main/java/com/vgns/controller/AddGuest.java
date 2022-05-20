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

@WebServlet("/AddGuest")
public class AddGuest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        LoginInfo guest = null;
        if (Objects.equals(password, password1) && mail!="" && name!="" && mobile!="" && address!="" && password!="") {
        }guest = new LoginInfo(name, mail, mobile, address, password);

        int status = GuestManagementDAO.addGuest(guest);

        if (status == 1) {
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
