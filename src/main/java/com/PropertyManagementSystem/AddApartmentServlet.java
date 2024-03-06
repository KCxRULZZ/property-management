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
 * Servlet implementation class AddApartmentServlet
 */
@WebServlet("/AddApartmentServlet")
public class AddApartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pName = request.getParameter("pName");
		String num_bedrooms = request.getParameter("num_bedrooms");
		String num_bathrooms = request.getParameter("num_bathrooms");
		String floor_number = request.getParameter("floor_number");
		String has_balcony = request.getParameter("has_balcony");
		String building_amenities = request.getParameter("building_amenities");

		int cNum_bedrooms = Integer.parseInt(num_bedrooms);
		int cNum_bathrooms = Integer.parseInt(num_bathrooms);
		int cFloor_number = Integer.parseInt(floor_number);
		
		boolean isTrue;
		
		isTrue = PropertyDBUtil.addApartment(pName, cNum_bedrooms, cNum_bathrooms, cFloor_number, has_balcony, building_amenities);
		
		HttpSession session = request.getSession();
		
		int SID =  (int) session.getAttribute("user_ID");
		
		List<Property> sellerProperty = SellerDBUtil.getSellerProperty(SID);
		request.setAttribute("sellerProperty", sellerProperty);
		
		List<User> SellerDetails = SellerDBUtil.getSeller(SID);
		request.setAttribute("SellerDetails", SellerDetails);
		
		if(isTrue == true) {
			request.setAttribute("success", "Apartment details added!");
			RequestDispatcher dis = request.getRequestDispatcher("seller_profile.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("error", "Sorry, Apartment adding was unsuccessful!");
			RequestDispatcher dis2 = request.getRequestDispatcher("seller_profile.jsp");
			dis2.forward(request, response);
		}
		
	}

}
