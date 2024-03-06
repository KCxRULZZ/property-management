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
 * Servlet implementation class UpdatePropertyServlet
 */
@WebServlet("/UpdatePropertyServlet")
public class UpdatePropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String PID = request.getParameter("PID");
		String pName = request.getParameter("pName");
		String pOwner = request.getParameter("pOwner");
		String pContact = request.getParameter("pContact");
		String pLocation = request.getParameter("pLocation");
		String pAmount = request.getParameter("pAmount");
		String pType = request.getParameter("property_type");
		
		HttpSession session = request.getSession();
		int OID = (int) session.getAttribute("user_ID");
		
		boolean isTrue;
		
		isTrue = PropertyDBUtil.updateProperty(PID, pName, pOwner, pContact, pLocation, pAmount, pType, OID);//call updateProperty function
		
		List<Property> sellerProperty = SellerDBUtil.getSellerProperty(OID);
		request.setAttribute("sellerProperty", sellerProperty);
		
		List<User> SellerDetails = SellerDBUtil.getSeller(OID);
		request.setAttribute("SellerDetails", SellerDetails);
		
		if(isTrue == true) {
			request.setAttribute("success", "Property successfully updated!");
			RequestDispatcher dis2 = request.getRequestDispatcher("seller_profile.jsp");
			dis2.forward(request, response);
		}else {
			request.setAttribute("error", "Sorry, user update was unsuccessful!");
			RequestDispatcher dis2 = request.getRequestDispatcher("seller_profile.jsp");
			dis2.forward(request, response);
		}
	}

}
