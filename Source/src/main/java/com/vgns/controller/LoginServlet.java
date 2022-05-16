package com.vgns.controller;

import com.vgns.dao.LoginDAO;
import com.vgns.dao.RoomManagementDAO;
import com.vgns.pojo.LoginInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (LoginDAO.isUserValid(new LoginInfo(userName, password))) {
        HttpSession session= request.getSession();

            session.setAttribute("userName", userName);
            session.setMaxInactiveInterval(200);

            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("loginFailed.jsp");
        }
    }
}
