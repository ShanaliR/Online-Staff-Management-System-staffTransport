package com.staffTransport;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TransportServlet")
public class TransportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // Create a PrintWriter to write response content in HTML format
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		// Retrieve user input parameters (name and email)
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		boolean isTrue;
		
		// Validate user input against the database
		isTrue=EmpTrDBUtil.validate(name, email);
		
		if(isTrue==true) {
			// If validation is successful, retrieve transport details and forward to "transportaccount.jsp"
			List<Transport> trDetails=EmpTrDBUtil.getTransport(name);
			request.setAttribute("trDetails",trDetails);
			
			RequestDispatcher dis=request.getRequestDispatcher("transportaccount.jsp");
			dis.forward(request, response);
		}else {
			// If validation fails, show an alert message and redirect back to "stransport.jsp"
			out.println("<script type='text/javascript'>");
			out.println("alert('Your name or email is incorrect');");
			out.println("location='stransport.jsp'");
			out.println("</script>");
		}
		
	}

}
