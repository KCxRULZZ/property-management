package com.PropertyManagementSystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_profile")
public class showDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			List<User> buyerDetails = UserDBUtil.getAllBuyers();
			request.setAttribute("buyerDetails", buyerDetails);
			
			List<User> sellerDetails = UserDBUtil.getAllSellers();
			request.setAttribute("sellerDetails",sellerDetails );
			
			List<Payment> paymentDetails = PaymentDBUtile.getAllPayment();
			request.setAttribute("paymentDetails", paymentDetails);
			
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
			RequestDispatcher dis = request.getRequestDispatcher("admin_profile.jsp");
			dis.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
