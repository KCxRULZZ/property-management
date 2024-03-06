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
 * Servlet implementation class DeletePropertyServlet
 */
@WebServlet("/DeletePropertyServlet")
public class DeletePropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pid = request.getParameter("deleteid");
		
		boolean isTrue;
		
		isTrue = SellerDBUtil.deleteProperty(pid);
		
		HttpSession session = request.getSession();
		
		int SID =  (int) session.getAttribute("user_ID");
		
		List<Property> sellerProperty = SellerDBUtil.getSellerProperty(SID);
		request.setAttribute("sellerProperty", sellerProperty);
		
		List<User> SellerDetails = SellerDBUtil.getSeller(SID);
		request.setAttribute("SellerDetails", SellerDetails);
		
		if(isTrue == true) {
			request.setAttribute("success", "User successfully deleted!");
			RequestDispatcher dis = request.getRequestDispatcher("seller_profile.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("error", "Sorry, user delete was unsuccessful!");
			RequestDispatcher dis2 = request.getRequestDispatcher("seller_profile.jsp");
			dis2.forward(request, response);
		}
		
	}

}
