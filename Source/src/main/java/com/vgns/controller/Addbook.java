package com.vgns.controller;

import com.vgns.dao.BookManagementDAO;
import com.vgns.dao.RoomManagementDAO;
import com.vgns.pojo.Room;
import com.vgns.pojo.booking;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Addbook", value = "/Addbook")
public class Addbook extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String cust_name = request.getParameter("userName");
     Integer roomId = Integer.parseInt(request.getParameter("roomId"));
     String checkin=request.getParameter("checkin");
     String checkout=request.getParameter("checkout");
        booking book= new booking(cust_name,roomId,checkin,checkout);

      int status = BookManagementDAO.addbook(book);
        if(status == 1)
        {
            response.sendRedirect("viewBooks.jsp");
        }
        else
        {
            response.sendRedirect("error.jsp");
        }
    }
}
