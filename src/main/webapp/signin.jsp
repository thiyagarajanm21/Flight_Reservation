<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewpoint" content="width=device-width, initial-scale=1.0">
<title>Flight Booking</title>
<link href="signin1.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="container">
    <%@ include file="header.jsp" %>

		<h1>Sign In</h1>
		<form action="header" method="post">
				<label for="uname">Email id:</label>
				<input type="email" name="uname" placeholder="Enter your email id" required>
				<label for="pass">Password:</label>
				<input type="password" name="pass" placeholder="Enter your password" required>
				<input type="submit" value="SignIn">
				Not a user<a href="signup.jsp">Sign Up</a>
		</form>
</div>
</body>
</html> 