package com.airline.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.Aflight;

public class AflightDAO {
	private static String JdbcURI="jdbc:mysql://localhost:3306/flight_reserve";
	private static String JdbcUser="root";
	private static String JdbcPass="1234";
    
    // Method to retrieve all flights from the database
    public static List<Aflight> getAllFlights() throws ClassNotFoundException {
        List<Aflight> flights = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(JdbcURI,JdbcUser,JdbcPass);
            String query = "SELECT * FROM flights";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Aflight flight = new Aflight();
                flight.setId(rs.getInt("id"));
                flight.setFlightNo(rs.getString("flightNo"));
                flight.setFlightName(rs.getString("flightName"));
                flight.setDepartureLocation(rs.getString("departureLocation"));
                flight.setDestination(rs.getString("destination"));
                flight.setTicketPrice(rs.getDouble("ticketPrice"));
                flight.setDate(rs.getString("date"));
                flight.setTime(rs.getString("time"));
                flights.add(flight);
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
        
        return flights;
    }
    
    //Update Flight Details(EDIT)
    public static void updateFlight(Aflight flight) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JdbcURI, JdbcUser, JdbcPass);
            String query = "UPDATE flights SET flightNo=?, flightName=?, departureLocation=?, destination=?, ticketPrice=?, date=?, time=? WHERE id=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, flight.getFlightNo());
            stmt.setString(2, flight.getFlightName());
            stmt.setString(3, flight.getDepartureLocation());
            stmt.setString(4, flight.getDestination());
            stmt.setDouble(5, flight.getTicketPrice());
            stmt.setString(6, flight.getDate());
            stmt.setString(7, flight.getTime());
            stmt.setInt(8, flight.getId());
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
    
    //Get FlightId
 // Method to get flight details by ID
    public static Aflight getFlightById(int id) throws ClassNotFoundException {
        Aflight flight = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JdbcURI, JdbcUser, JdbcPass);
            String query = "SELECT * FROM flights WHERE id=?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                flight = new Aflight();
                flight.setId(rs.getInt("id"));
                flight.setFlightNo(rs.getString("flightNo"));
                flight.setFlightName(rs.getString("flightName"));
                flight.setDepartureLocation(rs.getString("departureLocation"));
                flight.setDestination(rs.getString("destination"));
                flight.setTicketPrice(rs.getDouble("ticketPrice"));
                flight.setDate(rs.getString("date"));
                flight.setTime(rs.getString("time"));
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

        return flight;
    }
    
    //DELETE Flights
 // Method to delete a flight by ID
    public static void deleteFlight(int flightId) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JdbcURI, JdbcUser, JdbcPass);
            String query = "DELETE FROM flights WHERE id=?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, flightId);
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
}
