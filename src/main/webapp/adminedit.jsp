<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.airline.entity.Aflight" %>
<%@ page import="com.airline.dao.AflightDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Flight Details</title>
    <link href="adminedit.css" rel="stylesheet" type="text/css"/>
    
</head>
<body>
<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");

		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("signin.jsp");
		}
		%>
<jsp:include page="header.jsp" />

<div class="container">
<%
    // Assuming you have the flight ID available in a variable called flightId
    int flightId = Integer.parseInt(request.getParameter("id"));
    Aflight flight = AflightDAO.getFlightById(flightId);
%>
    <h1>Edit Flight Details</h1>
    <form action="updateFlight" method="post">
        <label for="flightNo">Flight No:</label>
        <input type="text" id="flightNo" name="flightNo" value="<%= flight.getFlightNo() %>" required><br>
        <label for="flightName">Flight Name:</label>
        <input type="text" id="flightName" name="flightName" value="<%= flight.getFlightName() %>" required><br>
        <label for="from">From:</label>
        <input type="text" id="from" name="from" value="<%= flight.getDepartureLocation() %>" required><br>
        <label for="to">To:</label>
        <input type="text" id="to" name="to" value="<%= flight.getDestination() %>" required><br>
        <label for="ticketPrice">Ticket Price:</label>
        <input type="text" id="ticketPrice" name="ticketPrice" value="<%= flight.getTicketPrice() %>" required><br>
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" value="<%= flight.getDate() %>" required><br>
        <label for="time">Time:</label>
        <input type="time" id="time" name="time" value="<%= flight.getTime() %>" required><br>
        <input type="hidden" name="id" value="<%= flight.getId() %>">
        <input type="submit" value="Update">
    </form>
</div>    
</body>
</html>
