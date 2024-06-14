<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <title>Flight Booking</title>
    <link href="header.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <header>
        <nav>
            <ul>
                <li>
                    <a href="index.jsp">
                        <img src="images/Logo.png" alt="Home Icon" class="nav-icon"/> Home
                    </a>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.username != 'admin@gmail.com'}">
                        <li><a href="usersflights.jsp">Flights</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="addflight.jsp">Add Flight</a></li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${sessionScope.username == 'admin@gmail.com'}">
                        <li><a href="adminflights.jsp"> Flights </a></li>
                    </c:when>
                    
                </c:choose>
                <c:choose>
                    <c:when test="${sessionScope.username != 'admin@gmail.com'}">
                        <li><a href="showbook.jsp">Bookings</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="showbook.jsp">Bookings</a></li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${empty sessionScope.username}">
                        <li><a href="signin.jsp">Sign In</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="signout.jsp">Sign Out</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
        <div class="users">
            <c:choose>
                <c:when test="${empty sessionScope.username}">
                    <span>Hello Guest</span>
                </c:when>
                <c:otherwise>
                    <span>Welcome, ${sessionScope.username}</span>
                </c:otherwise>
            </c:choose>
        </div>
    </header>
</body>
</html>
