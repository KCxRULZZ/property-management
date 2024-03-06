package com.PropertyManagementSystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PaymentDeleteServlet")
public class PaymentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id= request.getParameter("id");
		boolean isTrue;
		
		isTrue = PaymentDBUtile.deletePayment(id);
		
		if(isTrue ==true) {
			RequestDispatcher dispatcher =request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		else {
			RequestDispatcher dis=request.getRequestDispatcher("payment_Update.jsp");
			dis.forward(request, response);
		}
		
	}

}
