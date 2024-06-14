<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Booking</title>
<link href="styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <%@ include file="header.jsp" %>

    <!-- Main content of the home page -->
    <div class="content">
    
        <section class="banner">
            <div class="banner-overlay"></div>
            <div class="banner-text">
                <h1>Welcome to Flight Reservation System</h1>
                <p>Your one-stop solution for booking flights to your favorite destinations. Explore the world with ease and convenience.</p>
            </div>
        </section>
        
        <section class="featured-destinations">
            <h2>Featured Destinations</h2>
            <div class="destination-grid">
                <div class="destination">
                    <img src="images/prs.jpg" alt="Destination 1">
                    <h3>New York</h3>
                    <p>Explore the city of lights and its iconic landmarks.</p>
                </div>
                <div class="destination">
                    <img src="images/Ny.jpg" alt="Destination 2">
                    <h3>Paris</h3>
                    <p>The city that never sleeps awaits your visit.</p>
                </div>
                <div class="destination">
                    <img src="images/tky.jpg" alt="Destination 3">
                    <h3>Tokyo</h3>
                    <p>Experience the vibrant culture and technology hub.</p>
                </div>
            </div>
        </section>

        <section class="about-section">
            <h2>About Us</h2>
            <p>At Flight Reservation System, we are committed to providing the best travel experience. Our platform offers easy-to-use flight booking services, competitive prices, and exceptional customer support. Book your next flight with us and enjoy a seamless travel experience.</p>
        </section>
    </div>

    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
