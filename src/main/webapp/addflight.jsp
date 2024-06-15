<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Flights</title>
<link href="addflight.css" rel="stylesheet" type="text/css"/>

</head>
<body>
		<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");

		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("signin.jsp");
		}
		%>
<div class="container">
    <h1>Add Flight</h1>
    <form action="addFlight" method="post" onsubmit="return validateBooking()">
        <label for="flightNo">Flight No:</label>
        <input type="text" name="flightNo" placeholder="Enter flight number" required>
        <label for="flightName">Flight Name:</label>
        <input type="text" name="flightName" placeholder="Enter flight name" required>
        <label for="from">From:</label>
        <input type="text" name="from" placeholder="Enter departure location" required>
        <label for="to">To:</label>
        <input type="text" name="to" placeholder="Enter destination" required>
        <label for="ticketPrice">Ticket Price:</label>
        <input type="text" name="ticketPrice" placeholder="Enter ticket price" required>
        <label for="date">Date:</label>
        <input type="date" name="date" required>
        <label for="time">Time:</label>
        <input type="time" name="time" required>
        <input type="submit" value="Add Flight">
    </form>
</div>


</body>
</html>