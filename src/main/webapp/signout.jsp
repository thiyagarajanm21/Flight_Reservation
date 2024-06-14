<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>

<%
    session = request.getSession(false);
    if (session != null) {
        session.invalidate();
    }
    
    // Redirect to some other page after signout
    response.sendRedirect("index.jsp");
%>
