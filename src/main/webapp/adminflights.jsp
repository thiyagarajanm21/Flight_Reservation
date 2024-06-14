<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.airline.entity.Aflight, com.airline.dao.AflightDAO, java.util.*"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flights Information</title>
<link href="adminflights.css" rel="stylesheet" type="text/css"/>
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
    <h1>Flights Information</h1>
    <table border="1">
        <tr>
            <th>Flight No</th>
            <th>Flight Name</th>
            <th>Departure Location</th>
            <th>Destination</th>
            <th>Ticket Price</th>
            <th>Date</th>
            <th>Time</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <% 
            // Include your Java code to retrieve data from the database and populate the table here
            List<Aflight> flights = AflightDAO.getAllFlights(); // Assume FlightDAO is a class that handles database operations
            for (Aflight flight : flights) {
        %>
        <tr>
            <td><%= flight.getFlightNo() %></td>
            <td><%= flight.getFlightName() %></td>
            <td><%= flight.getDepartureLocation() %></td>
            <td><%= flight.getDestination() %></td>
            <td><%= flight.getTicketPrice() %></td>
            <td><%= flight.getDate() %></td>
            <td><%= flight.getTime() %></td>
            <td><a href="adminedit.jsp?id=<%= flight.getId() %>">Edit</a></td>
            <td><a href="deleteFlight?id=<%= flight.getId() %>" onclick="return confirm('Are you sure you want to delete this flight?')">Delete</a></td>
        </tr>
        <% } %>
    </table>
</div>

</body>
</html>
