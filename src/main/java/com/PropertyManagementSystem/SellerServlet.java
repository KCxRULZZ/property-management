package com.PropertyManagementSystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SellerServlet
 */
@WebServlet("/seller_profile")
public class SellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession session = request.getSession();
			
			int SID =  (int) session.getAttribute("user_ID");
			
			List<Property> sellerProperty = SellerDBUtil.getSellerProperty(SID);
			request.setAttribute("sellerProperty", sellerProperty);
			
			List<User> SellerDetails = SellerDBUtil.getSeller(SID);
			request.setAttribute("SellerDetails", SellerDetails);
			
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
			RequestDispatcher dis = request.getRequestDispatcher("seller_profile.jsp");
			dis.forward(request, response);
		
	}

}
