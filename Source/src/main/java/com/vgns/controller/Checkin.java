package com.vgns.controller;

import com.vgns.dao.BookManagementDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Checkin", value = "/Checkin")
public class Checkin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String checkind= request.getParameter("checkind");
      String checkoutd= request.getParameter("checkoutd");
      Integer roomid= Integer.parseInt(request.getParameter("roomid"));
      List<String> checklist= BookManagementDAO.validroom(roomid);
        List<String> checklist2= BookManagementDAO.validroom2(roomid);
        HttpSession session=request.getSession();
        session.setAttribute("roomid",roomid);
        session.setAttribute("checkind",checkind);
        session.setAttribute("checkoutd",checkoutd);
     if(checklist.isEmpty()){
         response.sendRedirect("confirmBook.jsp");
     }
     else{
         int status=0;
         for(int i=0;i<checklist.size();i++){
             if(BookManagementDAO.compareDates(checkind,checkoutd,checklist.get(i),checklist2.get(i))==1){
                 status++;
             }
         }
         if(status == checklist.size()){
             response.sendRedirect("confirmBook.jsp");
         }
         else{
             response.sendRedirect("Roomerror.jsp");
         }
     }
    }
}



