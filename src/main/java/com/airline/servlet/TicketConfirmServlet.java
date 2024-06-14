package com.airline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.airline.dao.BookDAO;
import com.airline.entity.BookingModel;

@WebServlet("/BookingServlet")
public class TicketConfirmServlet extends HttpServlet {
	    // Retrieve form data
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Retrieve form data
	    String passengerName = request.getParameter("passengerName");
	    String passengerEmail = request.getParameter("passengerEmail");
	    int passengerAge = Integer.parseInt(request.getParameter("passengerAge"));
	    String passengerAddress = request.getParameter("passengerAddress");
	    String passengerPhone = request.getParameter("passengerPhone");
	    
	    // Retrieve optional form data
//	    String spassengerName = request.getParameter("spassengerName");
////	    Integer spassengerAge = Integer.parseInt("spassengerAge"); 
//	    Integer spassengerAge = Integer.parseInt(request.getParameter("spassengerAge"));
//
//	    if(spassengerName == null)
//	    {
//	    	spassengerName="";
//	    }
//	    if(spassengerAge == null)
//	    {
//	    	spassengerAge=0;
//	    }
//	    
	 // Retrieve optional form data
//	    String spassengerName = request.getParameter("spassengerName");
//	    String spassengerAgeString = request.getParameter("spassengerAge");
//	    Integer spassengerAge = null;
//
//	    // Check if spassengerAgeString is not null before parsing
//	    if (spassengerAgeString != null && !spassengerAgeString.isEmpty()) {
//	        spassengerAge = Integer.parseInt(spassengerAgeString);
//	    }
//
//	    // Handle null or empty values for spassengerName
//	    if (spassengerName == null) {
//	        spassengerName = "";
//	    }

	    
	    // Retrieve flight details
	    String flightNo = request.getParameter("flightNo");
	    String flightName = request.getParameter("flightName");
	    String departure = request.getParameter("departureLocation");
	    String destination = request.getParameter("destination");
	    double ticketPrice = Double.parseDouble(request.getParameter("ticketPrice"));
	    String date = request.getParameter("date");
	    String time = request.getParameter("time");
	    String paymentmode = request.getParameter("paymentMode");


	    // Create a BookingModel object
	    BookingModel booking = new BookingModel();
	    booking.setPassengerName(passengerName);
	    booking.setPassengerEmail(passengerEmail);
	    booking.setPassengerAge(passengerAge);
	    booking.setPassengerAddress(passengerAddress);
	    booking.setPassengerPhone(passengerPhone);
//	    booking.setsPassengerName(spassengerName);
//	    booking.setsPassengerAge(spassengerAge);
	    // Set flight details
	    booking.setFlightNo(flightNo);
	    booking.setFlightName(flightName);
	    booking.setDepartureLocation(departure);
	    booking.setDestination(destination);
	    booking.setTicketPrice(ticketPrice);
	    booking.setDate(date);
	    booking.setTime(time);
	    booking.setPaymentMode(paymentmode);

	    // Insert booking into the database
	    try {
	        BookDAO.insertBooking(booking);
	        // Redirect to confirmation.jsp or any other page
	        response.sendRedirect("confirmation.jsp");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        // Handle error appropriately
	    }
	}



}
