package com.airline.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.airline.dao.AflightDAO;
import com.airline.entity.Aflight;

@WebServlet("/updateFlight")
public class FlightEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
		PrintWriter out=response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String flightNo = request.getParameter("flightNo");
        String flightName = request.getParameter("flightName");
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        double tprice =Double.parseDouble (request.getParameter("ticketPrice"));
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        // Retrieve other form fields similarly
        
        // Create Aflight object with updated data
        Aflight updatedFlight = new Aflight();
        updatedFlight.setId(id);
        updatedFlight.setFlightNo(flightNo);
        updatedFlight.setFlightName(flightName);
        updatedFlight.setDepartureLocation(from);
        updatedFlight.setDestination(to);
        updatedFlight.setTicketPrice(tprice);
        updatedFlight.setDate(date);
        updatedFlight.setTime(time);
        // Set other properties similarly
        
        // Update flight in database
        try {
            AflightDAO.updateFlight(updatedFlight);
            // Redirect to a success page or display a success message
            out.println("<html><head</head><body>");
        	out.println("<script>alert('Flight Details Updated Successfully..');</script>");
        	out.println("<script>window.location.href='adminflights.jsp';</script>");
        	out.println("</body></html>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exception or display error message
        }
    }
}
