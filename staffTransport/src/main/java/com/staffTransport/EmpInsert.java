package com.staffTransport;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet for entering a new employee
@WebServlet("/EmpInsert")
public class EmpInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve data from the request parameters
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String distance=request.getParameter("distance");
		
		boolean isTrue;
		// Call the EmpTrDBUtil class to attempt the insertion of a new employee transport record
		isTrue=EmpTrDBUtil.insertTrEmp(name, email, phone, address, distance);
		
		if(isTrue==true) {
			 // If insertion is successful, forward the request to "success.jsp"
			RequestDispatcher dis=request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
		}else {
			// If insertion fails, forward the request to "unsuccess.jsp"
			RequestDispatcher dis2=request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
