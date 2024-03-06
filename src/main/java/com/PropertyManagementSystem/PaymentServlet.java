package com.PropertyManagementSystem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Cnumber= request.getParameter("Cnumber");
		String name= request.getParameter("name");
		String Ctype= request.getParameter("Ctype");
		String address= request.getParameter("address");
		String Country= request.getParameter("Country");
		
		
		boolean isTrue;
		
		isTrue = PaymentDBUtile.PaymentSend(Cnumber, name, Ctype, address, Country);
		
		if(isTrue == true) {
			request.setAttribute("success", " Payment Successfull !");
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("error", "Sorry,Your payment is not Successfull!");
			RequestDispatcher dis2 = request.getRequestDispatcher("PaymentPage.jsp");
			dis2.forward(request, response);
		}
		
	
	
	}

}
