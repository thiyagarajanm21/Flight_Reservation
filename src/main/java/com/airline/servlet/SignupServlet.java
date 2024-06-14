package com.airline.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			String uname=request.getParameter("uname");
			String email=request.getParameter("mail");
		    String pass=request.getParameter("pass");
		    String cpass=request.getParameter("cpass");
		    if(pass!=cpass)
		    {
		    	
		    }
		    
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_reserve", "root", "1234");
		Statement stmt = con.createStatement();
		ResultSet result=stmt.executeQuery("SELECT EXISTS(SELECT * FROM USERS WHERE mail='"+email+"')");
		int i=0;
        while(result.next())
        {
            i=result.getInt(1);
        }
        if(i==0)
        {
        	stmt.execute("INSERT INTO USERS(uname,mail,password) VALUES('"+uname+"','"+email+"','"+pass+"')");
        	out.println("<html><head><title>SignUp successful</title></head><body>");
        	out.println("<script>alert('SignUp Successfully..');</script>");
        	out.println("<script>window.location.href='signin.jsp';</script>");
        	out.println("</body></html>");
        	

        }
        else
    	{
        	out.println("<html><head><title>Signup Failed</title></head><body>");
        	out.println("<script>alert('Already signup..');</script>");
        	out.println("<script>window.location.href='signin.jsp';</script>");
        	out.println("</body></html>");

    	}
        
		}
		catch(Exception e)
		{
			out.println(e);
		}

	
	}	


}
