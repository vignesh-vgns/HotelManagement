<%@page import="com.vgns.dao.LoginDAO"%>
<%@page import="com.vgns.pojo.LoginInfo"%>
<%

String userName = request.getParameter("userName");
String password = request.getParameter("password");

if(LoginDAO.isUserValid(new LoginInfo(userName,password)))
{

	session.setAttribute("userName",userName);
	session.setMaxInactiveInterval(200);
	response.sendRedirect("home.jsp"); 
}
else 
{
	response.sendRedirect("loginFailed.jsp");
}
%>