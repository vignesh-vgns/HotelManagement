<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
	<style>
		.navbar {
			overflow: hidden;
			background-color: #3b5998;
			font-family: Arial, Helvetica, sans-serif;
		}

		.navbar a {
			float: left;
			font-size: 16px;
			color: white;
			text-align: center;
			padding: 14px 16px;
			text-decoration: none;
		}

		.dropdown {
			float: right;
			overflow: hidden;
		}

		.dropdown .dropbtn {
			cursor: pointer;
			font-size: 16px;
			border: none;
			outline: none;
			color: white;
			padding: 14px 16px;
			background-color: inherit;
			font-family: inherit;
			margin: 0;
		}

		.navbar a:hover, .dropdown:hover .dropbtn, .dropbtn:focus {
			background-color: #808cff;
		}

		.dropdown-content {
			display: none;
			position: absolute;
			background-color: #f9f9f9;
			min-width: 160px;
			box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
			z-index: 1;
		}

		.dropdown-content a {
			float: none;
			color: black;
			padding: 12px 16px;
			text-decoration: none;
			display: block;
			text-align: left;
		}

		.dropdown-content a:hover {
			background-color: #ddd;
		}

		.show {
			display: block;
		}
	</style>
	<script>
		/* When the user clicks on the button,
        toggle between hiding and showing the dropdown content */
		function myFunction() {
			document.getElementById("myDropdown").classList.toggle("show");
		}

		// Close the dropdown if the user clicks outside of it
		window.onclick = function(e) {
			if (!e.target.matches('.dropbtn')) {
				var myDropdown = document.getElementById("myDropdown");
				if (myDropdown.classList.contains('show')) {
					myDropdown.classList.remove('show');
				}
			}
		}
	</script>
</head>
<body>

	<%
	if(session.getAttribute("userName") == null)
	{
		response.sendRedirect("index.jsp");
	}
	String userName = (String)session.getAttribute("userName");
	%>
	<nav class="navbar">
		<ul class="navbar-nav">
			<li><a href="home.jsp">Home</a></li>
			<li><a href="viewRooms.jsp">View Rooms</a></li>
			<li><a href="searchRoom.jsp">Search Rooms</a></li>
			<li><a href="viewBooks.jsp">Bookings</a></li>
			<li><a href="checkin.jsp">Check In</a></li>
			<li><a href="checkout.jsp">Check Out</a></li>
			<div class="dropdown">
				<button class="dropbtn" onclick="myFunction()">My Account
					<i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content" id="myDropdown">
					<a href="viewProfile.jsp">My Profile</a>
					<a href="editGuest.jsp">Edit Profile</a>
					<a href="logout.jsp">Logout</a>
				</div>
			</div>
		</ul>
	</nav>
</body>
</html>