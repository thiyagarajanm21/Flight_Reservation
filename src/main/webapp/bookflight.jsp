<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<%@ page import="com.airline.entity.Aflight" %>
<%@ page import="com.airline.dao.AflightDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.airline.entity.BookingModel" %>
<%@ page import="com.airline.dao.BookDAO" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Flight</title>
<link href="header.css" rel="stylesheet" type="text/css"/>
<link href="bookflight.css" rel="stylesheet" type="text/css"/>
</head>
<body> 
<jsp:include page="header.jsp" />

<div class="container">
 <%
        if(session.getAttribute("username")==null) {
            response.sendRedirect("signin.jsp");
        }
    %>
<%
    session = request.getSession(false);
    String userEmail = null;
    if (session != null) {
        userEmail = (String) session.getAttribute("username");
    }
%>    
    <h1>Reserve Your Wings</h1>
    <form action="BookingServlet" method="post"> <!-- Add form tag here -->
        <h2>User Details:</h2>
        <div id="userDetails">
            <label>Passenger Name: <input type="text" name="passengerName" id="passengerName" required></label><br>
            <label>Email: <input type="text" name="passengerEmail" id="passengerEmail" value="<%= userEmail %>" ></label><br>
            <label>Age: <input type="text" name="passengerAge" id="passengerAge" required></label><br>
            <label>Address: <input type="text" name="passengerAddress" id="passengerAddress" required></label><br>
            <label>Phone No: <input type="text" name="passengerPhone" id="passengerPhone" required></label><br>
        </div> 
        <% int flightId = Integer.parseInt(request.getParameter("id")); %>
        <% Aflight flight = AflightDAO.getFlightById(flightId); %>
        <h2>Flight Details:</h2>
        <div id="flightDetails">
            <label>Flight No: <%= flight.getFlightNo() %></label><br>
            <label>Flight Name: <%= flight.getFlightName() %></label><br>
            <label>Departure: <%= flight.getDepartureLocation() %></label><br>
            <label>Destination: <%= flight.getDestination() %></label><br>
            <label>Ticket Price: <span id="ticketPrice"><%= flight.getTicketPrice() %></span></label><br>
            <label>Date: <%= flight.getDate() %></label><br>
            <label>Time: <%= flight.getTime() %></label><br>
        </div>
        <input type="hidden" name="flightNo" value="<%= flight.getFlightNo() %>">
        <input type="hidden" name="flightName" value="<%= flight.getFlightName() %>">
        <input type="hidden" name="departureLocation" value="<%= flight.getDepartureLocation() %>">
        <input type="hidden" name="destination" value="<%= flight.getDestination() %>">
        <input type="hidden" name="ticketPrice" value="<%= flight.getTicketPrice() %>">
        <input type="hidden" name="date" value="<%= flight.getDate() %>">
        <input type="hidden" name="time" value="<%= flight.getTime() %>">

        <h2>Payment Details:</h2>
        <div>
            <label>Select Payment Mode:</label>
            <select name="paymentMode" id="paymentMode">
                <option value="debitCard">Debit Card</option>
                <option value="creditCard">Credit Card</option>
            </select><br>
            <button type="submit">Book</button> <!-- Submit button moved inside the form -->
        </div>
    </form> <!-- Close the form tag here -->
    </div>
</body>
</html>
