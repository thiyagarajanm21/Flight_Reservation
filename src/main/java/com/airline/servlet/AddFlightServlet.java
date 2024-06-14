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

@WebServlet("/addFlight")
public class AddFlightServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			String fno=request.getParameter("flightNo");
			String fname=request.getParameter("flightName");
		    String from=request.getParameter("from");
		    String to=request.getParameter("to");
		    String tprice=request.getParameter("ticketPrice");
		    String date=request.getParameter("date");
		    String time=request.getParameter("time");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_reserve", "root", "1234");
		Statement stmt = con.createStatement();
		ResultSet result=stmt.executeQuery("SELECT EXISTS(SELECT * FROM FLIGHTS WHERE flightno='"+fno+"')");
		int i=0;
        while(result.next())
        {
            i=result.getInt(1);
        }
        if(i==0)
        {
        	stmt.execute("INSERT INTO FLIGHTS(flightNo,flightName,departureLocation,destination,ticketPrice,date,time) VALUES('"+fno+"','"+fname+"','"+from+"','"+to+"','"+tprice+"','"+date+"','"+time+"')");
        	out.println("<html><head</head><body>");
        	out.println("<script>alert('Flight Added Successfully..');</script>");
        	out.println("<script>window.location.href='index.jsp';</script>");
        	out.println("</body></html>");
        	

        }
        else
    	{
        	out.println("<html><head><title></title></head><body>");
        	out.println("<script>alert('Flight Number Already Exist..');</script>");
//        	out.println("<script>window.location.href='addflight.jsp';</script>");
        	out.println("</body></html>");

    	}
        
		}
		catch(Exception e)
		{
			out.println(e);
		}

	
	}	


}

