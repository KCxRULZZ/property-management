package com.PropertyManagementSystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("Bid");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		
		String referringPage = request.getHeader("Referer");
		request.getSession().setAttribute("referringPage", referringPage);
		
		boolean isTrue;
		
		isTrue = UserDBUtil.updateUser(id, name, gender, phone, email, address, dob);
		
			List<User> buyerDetails = UserDBUtil.getAllBuyers();
			request.setAttribute("buyerDetails", buyerDetails);
			
			List<User> sellerDetails = UserDBUtil.getAllSellers();
			request.setAttribute("sellerDetails",sellerDetails );
			
			List<Payment> paymentDetails = PaymentDBUtile.getAllPayment();
			request.setAttribute("paymentDetails", paymentDetails);
		
		if(isTrue == true) {
			// Add a success message to the request attributes
		    request.setAttribute("successMessage", "User updated successfully!");
		    
		    // Retrieve the stored referring page URL
		    String referringPages = (String) request.getSession().getAttribute("referringPage");

		    // Redirect to the referring page
		    if (referringPages != null && !referringPages.isEmpty()) {
		        response.sendRedirect(referringPages);
		    }
		}else {
			request.setAttribute("error", "Sorry, user update was unsuccessful!");
			RequestDispatcher dis2 = request.getRequestDispatcher("admin_profile.jsp");
			dis2.forward(request, response);
		}
		
	}

}
