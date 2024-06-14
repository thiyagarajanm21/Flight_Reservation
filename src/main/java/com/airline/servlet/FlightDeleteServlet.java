package com.airline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.airline.dao.AflightDAO;

@WebServlet("/deleteFlight")
public class FlightDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int flightId = Integer.parseInt(request.getParameter("id"));
        try {
            AflightDAO.deleteFlight(flightId);
            // Redirect to a success page or display a success message
            response.sendRedirect("adminflights.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exception or display error message
        }
    }
}
