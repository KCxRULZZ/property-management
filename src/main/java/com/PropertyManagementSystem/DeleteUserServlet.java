package com.PropertyManagementSystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("deleteid");
		
		boolean isTrue;
		
		isTrue = UserDBUtil.deleteUser(id);
		
		List<User> buyerDetails = UserDBUtil.getAllBuyers();
		request.setAttribute("buyerDetails", buyerDetails);
		
		List<User> sellerDetails = UserDBUtil.getAllSellers();
		request.setAttribute("sellerDetails",sellerDetails );
		
		List<Payment> paymentDetails = PaymentDBUtile.getAllPayment();
		request.setAttribute("paymentDetails", paymentDetails);
		
		if(isTrue == true) {
			request.setAttribute("success", "User successfully deleted!");
			RequestDispatcher dis = request.getRequestDispatcher("admin_profile.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("error", "Sorry, user delete was unsuccessful!");
			RequestDispatcher dis2 = request.getRequestDispatcher("admin_profile.jsp");
			dis2.forward(request, response);
		}
		
	}

}
