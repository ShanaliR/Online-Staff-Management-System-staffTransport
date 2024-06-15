package com.staffTransport;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteTransportServlet")
public class DeleteTransportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the employee ID to be deleted from the request
		String id=request.getParameter("empid");
		boolean isTrue;
		 // Call the EmpTrDBUtil class to attempt the deletion
		isTrue=EmpTrDBUtil.deleteTransport(id);
		
		if(isTrue==true) {
			// If deletion is successful, forward the request to "EmpInsert.jsp"
			RequestDispatcher dispatcher=request.getRequestDispatcher("EmpInsert.jsp");
			dispatcher.forward(request, response);	
		}
		else {
			// If deletion fails, retrieve transport details and forward the request to "transportaccount.jsp"
			List<Transport> trDetails= EmpTrDBUtil.getTransportDetails(id);
			request.setAttribute("trDetails", trDetails);
			
			RequestDispatcher dis=request.getRequestDispatcher("transportaccount.jsp");
			dis.forward(request, response);
		}
		
	}

}
