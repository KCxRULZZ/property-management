package com.PropertyManagementSystem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PaymentUpdateServlet")
public class PaymentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String Cnumber = request.getParameter("Cnumber");
		String name = request.getParameter("name");
		String Ctype = request.getParameter("Ctype");
		String address = request.getParameter("address");
		String Country = request.getParameter("Country");
		
		boolean isTrue;
		
		
		isTrue = PaymentDBUtile.updatePayment( id, Cnumber, name, Ctype, address, Country) ;
				
		if(isTrue==true) {
			RequestDispatcher dis=request.getRequestDispatcher("index.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis=request.getRequestDispatcher("payment_Update.jsp");
			dis.forward(request, response);
		}
	}

}
