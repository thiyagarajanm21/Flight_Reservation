package com.airline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//
//@WebServlet("/BookFlightServlet")
//public class BookingServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Retrieve flightId and userId from request parameters
//        int flightId = Integer.parseInt(request.getParameter("flightId"));
////        int userId = Integer.parseInt(request.getParameter("userId"));
//        
//        // Set flightId and userId as attributes in the request
//        request.setAttribute("flightId", flightId);
////        request.setAttribute("userId", userId);
//        
//        // Forward the request to the Stage-2 JSP
//        request.getRequestDispatcher("bookflight.jsp").forward(request, response);
//    }
//}
//BookingServlet.java
@WebServlet("/BookFlightServlet")
public class BookingServlet extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     // Retrieve flightId from request parameters
     int flightId = Integer.parseInt(request.getParameter("flightId"));
     
     // Retrieve username from session
     HttpSession session = request.getSession(false);
     String username = (String) session.getAttribute("username");
     String password = request.getParameter("pass");

     // Set username as attribute in the request
     request.setAttribute("username", username);
     
     // Forward the request to the Stage-2 JSP
     request.getRequestDispatcher("bookflight.jsp").forward(request, response);
 }
}
