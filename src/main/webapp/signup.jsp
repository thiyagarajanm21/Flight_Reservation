<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewpoint" content="width=device-width, initial-scale=1.0">
<title>Flight Booking</title>
<link href="signup.css" rel="stylesheet" type="text/css"/>

<script>
    function validatePassword() {
        var pass1 = document.getElementById("pass").value;
        var pass2 = document.getElementById("cpass").value;
        if (pass1 != pass2) {
            alert("Password do not match");
            return false;
        }
        return true;
    }
</script>

</head>
<body>

<div class="container">
    <%@ include file="header.jsp" %>

		<h1>Sign up</h1>
		<form action="signup" method="post" onsubmit="return validatePassword()" >
				<label for="uname">Username:</label>
				<input type="text" name="uname" placeholder="Enter your username" required>
				<label for="mail">Email:</label>
				<input type="email" name="mail" placeholder="Enter your mail id" required>
				<label for="pass">Password:</label>
				<input type="password" name="pass" id="pass" placeholder="Enter your password" required>
				<label for="cpass"> Confirm Password:</label>
				<input type="password" name="cpass" id="cpass" placeholder="Confirm your password" required>
				<input type="submit" value="Sign up">

		</form>
</div>

</body>
</html>