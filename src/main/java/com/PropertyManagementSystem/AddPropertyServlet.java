package com.PropertyManagementSystem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddPropertyServlet
 */
@WebServlet("/AddPropertyServlet")
public class AddPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String pName = request.getParameter("pName");
		String pOwner = request.getParameter("pOwner");
		String pContact = request.getParameter("pContact");
		String pLocation = request.getParameter("pLocation");
		String pAmount = request.getParameter("pAmount");
		String property_type = request.getParameter("property_type");
		
		int OID =(int) session.getAttribute("user_ID");
		
		
		boolean isTrue;
		
		isTrue = SellerDBUtil.addProperty(pName, pOwner, pContact, pLocation, pAmount, property_type, OID);
		
		session.setAttribute("property_name", pName); //which type of property
		
		if(isTrue == true && property_type.equals("House")) {
			request.setAttribute("success", "Property Ad successful, please enter the house details");
			RequestDispatcher dis = request.getRequestDispatcher("add_house.jsp"); 
			dis.forward(request, response);
			
		}else if (isTrue == true && property_type.equals("Apartment")){
			request.setAttribute("success", "Property Ad successful, please enter the apartment details");
			RequestDispatcher dis2 = request.getRequestDispatcher("add_apartment.jsp");
			dis2.forward(request, response);
			
		}else if (isTrue == true && property_type.equals("Land")) {
			request.setAttribute("success", "Property Ad successful, please enter the land details");
			RequestDispatcher dis2 = request.getRequestDispatcher("add_land.jsp");
			dis2.forward(request, response);
		}else {
			request.setAttribute("error", "Sorry, property adding was unsuccessful!");
			RequestDispatcher dis2 = request.getRequestDispatcher("register.jsp");
			dis2.forward(request, response);
		}
		
	}

}
