package com.airline.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.Aflight;
import com.airline.entity.UsersModel;

public class Udao {
	private static String JdbcURI="jdbc:mysql://localhost:3306/flight_reserve";
	private static String JdbcUser="root";
	private static String JdbcPass="1234";
	public static List<UsersModel> getAllUsers() throws ClassNotFoundException {
        List<UsersModel> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(JdbcURI,JdbcUser,JdbcPass);
            String query = "SELECT * FROM users";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            	UsersModel user = new UsersModel();
                user.setId(rs.getInt("id"));
                user.setUname(rs.getString("uname"));
                user.setMail(rs.getString("mail"));
                
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
        
        return users;
    }
	
	//Get User by Id
	 public static UsersModel getUserById(int id) throws ClassNotFoundException {
		    UsersModel users = null;
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(JdbcURI, JdbcUser, JdbcPass);
	            String query = "SELECT * FROM users WHERE id=?";
	            stmt = conn.prepareStatement(query);
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();

	            if (rs.next()) {
	            	users=new UsersModel();
	            	users.setId(rs.getInt("id"));
	                users.setUname(rs.getString("uname"));
	                users.setMail(rs.getString("mail"));
	               
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

	        return users;
	    }

	}

