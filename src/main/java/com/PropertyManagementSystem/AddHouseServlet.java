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

@WebServlet("/AddHouseServlet")
public class AddHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pName = request.getParameter("pName");
		String num_bedrooms = request.getParameter("num_bedrooms");
		String num_bathrooms = request.getParameter("num_bathrooms");
		String square_footage = request.getParameter("square_footage");
		String has_garage = request.getParameter("has_garage");
		String house_amenities = request.getParameter("house_amenities");
		
		int cNum_bedrooms = Integer.parseInt(num_bedrooms);
		int cNum_bathrooms = Integer.parseInt(num_bathrooms);
		double cSquare_footage = Double.parseDouble(square_footage);
		
		boolean isTrue;
		
		isTrue = PropertyDBUtil.addHouse(pName, cNum_bedrooms, cNum_bathrooms, cSquare_footage, has_garage, house_amenities);
		
		HttpSession session = request.getSession();
		
		int SID =  (int) session.getAttribute("user_ID");
		
		List<Property> sellerProperty = SellerDBUtil.getSellerProperty(SID);
		request.setAttribute("sellerProperty", sellerProperty);
		
		List<User> SellerDetails = SellerDBUtil.getSeller(SID);
		request.setAttribute("SellerDetails", SellerDetails);
		
		if(isTrue == true) {
			request.setAttribute("success", "House details added!");
			RequestDispatcher dis = request.getRequestDispatcher("seller_profile.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("error", "Sorry, House adding was unsuccessful!");
			RequestDispatcher dis2 = request.getRequestDispatcher("seller_profile.jsp");
			dis2.forward(request, response);
		}
		
	}

}
