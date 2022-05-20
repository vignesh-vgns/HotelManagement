<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Sign UP</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div align="center">
    <form action="AddGuest" method="post">
        <table class="productTable">
            <thead>
            <tr>
                <th colspan="2">
                   Enter your details
                </th>
            </tr>
            </thead>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" size="20"
                           class="productTextField" /></td>
            </tr>
            <tr>
                <td>Mail Id</td>
                <td><input type="text" name="mail" size="20"
                           class="productTextField" /></td>
            </tr>
            <tr>
                <td>Mobile number</td>
                <td><input type="text" name="mobile" size="20"
                           class="productTextField" /></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" size="20"
                           class="productTextField" /></td>
            </tr>
            <tr>
                <td>Set password</td>
                <td><label>
                    <input type="password" name="password" size="20"
                               style="height: 25px;
    border-radius: 5px;
    padding-left: 5px" />
                </label></td>
            </tr>
            <tr>
                <td>Re-enter password</td>
                <td><label>
                    <input type="password" name="password1" size="20"
                               class="productTextField" />
                </label></td>
            </tr>
        </table>
        <button class="actionBtn" style="margin-top:10px">Register</button>
    </form>
</div>
</body>
</html>