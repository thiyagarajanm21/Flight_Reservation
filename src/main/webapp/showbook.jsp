<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.airline.entity.BookingModel" %>
<%@ page import="com.airline.dao.BookDAO" %>
<%@ page import="java.util.List" %>

<%
// Retrieve the role of the logged-in user from the session
String role = (String) session.getAttribute("username");

// Check if the user is an admin
boolean isAdmin = "admin@gmail.com".equals(role);

// If the user is not an admin, retrieve bookings only for the respective user
List<BookingModel> bookings;
if (isAdmin) {
    bookings = BookDAO.getAllBookings(); // Retrieve all bookings for the admin
} else {
    String username = (String) session.getAttribute("username");
    bookings = BookDAO.getUserBookings(username); // Retrieve bookings for the logged-in user
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Information</title>
<link href="show.css" rel="stylesheet" type="text/css"/>
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

<h1>Booking Information</h1>

<table border="1">
    <tr>
        <th>Passenger Name</th>
        <th>Email</th>
        <th>Age</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Flight No</th>
        <th>Flight Name</th>
        <th>Departure Location</th>
        <th>Destination</th>
        <th>Ticket Price</th>
        <th>Date</th>
        <th>Time</th>
        <th>Payment Mode</th>
    </tr>
    <% for (BookingModel booking : bookings) { %>
    <tr>
        <td><%= booking.getPassengerName() %></td>
        <td><%= booking.getPassengerEmail() %></td>
        <td><%= booking.getPassengerAge() %></td>
        <td><%= booking.getPassengerAddress() %></td>
        <td><%= booking.getPassengerPhone() %></td>
        <td><%= booking.getFlightNo() %></td>
        <td><%= booking.getFlightName() %></td>
        <td><%= booking.getDepartureLocation() %></td>
        <td><%= booking.getDestination() %></td>
        <td><%= booking.getTicketPrice() %></td>
        <td><%= booking.getDate() %></td>
        <td><%= booking.getTime() %></td>
        <td><%= booking.getPaymentMode() %></td>
    </tr>
    <% } %>
</table>
</div>
</body>
</html>
