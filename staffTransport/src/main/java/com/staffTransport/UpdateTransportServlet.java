package com.staffTransport;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateTransportServlet")
public class UpdateTransportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve parameters from the request
		String id=request.getParameter("empid");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String distance=request.getParameter("distance");
		
		boolean isTrue;
		
		 // Call the utility class to update transport details
		isTrue=EmpTrDBUtil.updateTransport(id, name, email, phone, address, distance);
		
		if(isTrue == true) {
			// If the update is successful, retrieve transport details and forward to "transportaccount.jsp"
			List<Transport> trDetails= EmpTrDBUtil.getTransportDetails(id);
			request.setAttribute("trDetails", trDetails);
			
			RequestDispatcher dis=request.getRequestDispatcher("transportaccount.jsp");
			dis.forward(request, response);
		}
		else {
			 // If the update fails, still retrieve transport details and forward to "transportaccount.jsp"
			List<Transport> trDetails= EmpTrDBUtil.getTransportDetails(id);
			request.setAttribute("trDetails", trDetails);
			
			RequestDispatcher dis=request.getRequestDispatcher("transportaccount.jsp");
			dis.forward(request, response);
		}
	}	

}
