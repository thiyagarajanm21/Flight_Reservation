//package com.airline.servlet;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet("/header")
//public class HeaderServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("uname");
//        String password = request.getParameter("pass");
//        
//        // You need to implement your own logic for user authentication
//        // For demonstration purposes, let's assume authentication is successful
//        boolean isAuthenticated = true; // Replace with your authentication logic
//        
//        if (isAuthenticated) {
//            // Set user session attributes
//            HttpSession session = request.getSession();
//            session.setAttribute("username", username);
//            
//            // Redirect to home page or any other desired page
//            response.sendRedirect("home.jsp");
//        } else {
//            // Authentication failed, redirect back to sign-in page with an error message
//            response.sendRedirect("signin.jsp?error=1");
//        }
//    }
//}

package com.airline.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
    
   

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Database connection
		PrintWriter out=response.getWriter();

        try  {
            // SQL query to retrieve username and password
        	String username = request.getParameter("uname");
            String password = request.getParameter("pass");
            
    		Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_reserve", "root", "1234");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE mail = '"+username+"' AND password = '"+password+"'");
            
            if (rs.next()) {
                // Authentication successful
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                
                // Redirect to home page or any other desired page
                response.sendRedirect("index.jsp");
            } else {
                // Authentication failed, display window alert message
//                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Username or password is incorrect');");
                out.println("location='signin.jsp';");
                out.println("</script>");
            }
        } catch (Exception e) {
            // Handle database connection errors
            
            // Redirect to an error page or show an error message
        	out.println(e);
        }
    }
}

