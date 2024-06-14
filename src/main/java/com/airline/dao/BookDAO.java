package com.airline.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.BookingModel;

public class BookDAO {
	private static String JdbcURI="jdbc:mysql://localhost:3306/flight_reserve";
	private static String JdbcUser="root";
	private static String JdbcPass="1234";
    
    // Method to retrieve all bookings from the database
	public static List<BookingModel> getAllBookings() throws ClassNotFoundException {
	    List<BookingModel> books = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn=DriverManager.getConnection(JdbcURI,JdbcUser,JdbcPass);
	        String query = "SELECT * FROM bookings";
	        stmt = conn.prepareStatement(query);
	        rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            BookingModel book = new BookingModel();
	            book.setId(rs.getInt("id"));
	            book.setPassengerName(rs.getString("passenger_name"));
	            book.setPassengerEmail(rs.getString("passenger_email"));
	            book.setPassengerAge(rs.getInt("passenger_age"));
	            book.setPassengerAddress(rs.getString("passenger_address"));
	            book.setPassengerPhone(rs.getString("passenger_phone"));
	            book.setFlightNo(rs.getString("flight_no"));
	            book.setFlightName(rs.getString("flight_name"));
	            book.setDepartureLocation(rs.getString("departure_location"));
	            book.setDestination(rs.getString("destination"));
	            book.setTicketPrice(rs.getDouble("ticket_price"));
	            book.setDate(rs.getString("flight_date"));
	            book.setTime(rs.getString("flight_time"));
	            book.setPaymentMode(rs.getString("payment_mode"));
	            
	            books.add(book); // Add the created BookingModel object to the list
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return books;
	}

    
    public static void insertBooking(BookingModel booking) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JdbcURI, JdbcUser, JdbcPass);

            String query = "INSERT INTO bookings (passenger_name, passenger_email, passenger_age, " +
                           "passenger_address, passenger_phone, flight_no, " +
                           "flight_name, departure_location, destination, ticket_price, flight_date, flight_time, payment_mode) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            stmt = conn.prepareStatement(query);
            stmt.setString(1, booking.getPassengerName());
            stmt.setString(2, booking.getPassengerEmail());
            stmt.setInt(3, booking.getPassengerAge());
            stmt.setString(4, booking.getPassengerAddress());
            stmt.setString(5, booking.getPassengerPhone());
            stmt.setString(6, booking.getFlightNo());
            stmt.setString(7, booking.getFlightName());
            stmt.setString(8, booking.getDepartureLocation());
            stmt.setString(9, booking.getDestination());
            stmt.setDouble(10, booking.getTicketPrice());
            stmt.setString(11, booking.getDate());
            stmt.setString(12, booking.getTime());
            stmt.setString(13, booking.getPaymentMode());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //Getting User Bookings
    public static List<BookingModel> getUserBookings(String username) throws ClassNotFoundException {
        List<BookingModel> userBookings = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JdbcURI, JdbcUser, JdbcPass);
            
            // Query to retrieve bookings for the given username
            String query = "SELECT * FROM bookings WHERE passenger_email = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            
            // Loop through the result set and populate the list of user bookings
         // Loop through the result set and populate the list of user bookings
            while (rs.next()) {
                BookingModel booking = new BookingModel();
                // Populate booking attributes
                booking.setId(rs.getInt("id"));
                booking.setPassengerName(rs.getString("passenger_name"));
                booking.setPassengerEmail(rs.getString("passenger_email"));
                booking.setPassengerAge(rs.getInt("passenger_age"));
                booking.setPassengerAddress(rs.getString("passenger_address"));
                booking.setPassengerPhone(rs.getString("passenger_phone"));
                booking.setFlightNo(rs.getString("flight_no"));
                booking.setFlightName(rs.getString("flight_name"));
                booking.setDepartureLocation(rs.getString("departure_location"));
                booking.setDestination(rs.getString("destination"));
                booking.setTicketPrice(rs.getDouble("ticket_price"));
                booking.setDate(rs.getString("flight_date"));
                booking.setTime(rs.getString("flight_time"));
                booking.setPaymentMode(rs.getString("payment_mode"));
                
                // Add booking to the list
                userBookings.add(booking);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return userBookings;
    }
}
