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
 * Servlet implementation class AddLandServlet
 */
@WebServlet("/AddLandServlet")
public class AddLandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String property_name = request.getParameter("property_name");
		String land_area = request.getParameter("land_area");
		String zoning_type = request.getParameter("zoning_type");
		String land_topography = request.getParameter("land_topography");
		String land_accessibility = request.getParameter("land_accessibility");
		String potential_landuse = request.getParameter("potential_landuse");
		
		double cLand_area = Double.parseDouble(land_area);
		
		boolean isTrue;
		
		isTrue = PropertyDBUtil.addLand(property_name, cLand_area, zoning_type, land_topography, land_accessibility, potential_landuse);
		
		HttpSession session = request.getSession();
		
		int SID =  (int) session.getAttribute("user_ID");
		
		List<Property> sellerProperty = SellerDBUtil.getSellerProperty(SID);
		request.setAttribute("sellerProperty", sellerProperty);
		
		List<User> SellerDetails = SellerDBUtil.getSeller(SID);
		request.setAttribute("SellerDetails", SellerDetails);
		
		if(isTrue == true) {
			request.setAttribute("success", "Land details added!");
			RequestDispatcher dis = request.getRequestDispatcher("seller_profile.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("error", "Sorry, Land adding was unsuccessful!");
			RequestDispatcher dis2 = request.getRequestDispatcher("seller_profile.jsp");
			dis2.forward(request, response);
		}
		
	}

}
