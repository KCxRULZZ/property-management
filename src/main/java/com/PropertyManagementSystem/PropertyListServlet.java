package com.PropertyManagementSystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PropertyListServlet")
public class PropertyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			List<Property> propertyList = PropertyDBUtil.getAllProperties();
			request.setAttribute("propertyList", propertyList);
			
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
			RequestDispatcher dis = request.getRequestDispatcher("property_list.jsp");
			dis.forward(request, response);
		}

}
