package com.PropertyManagementSystem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteBuyerServlet
 */
@WebServlet("/DeleteBuyerServlet")
public class DeleteBuyerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("deleteid");
		
		boolean isTrue;
		boolean isTrue2;
		
		isTrue = UserDBUtil.deleteUser(id);
		
		isTrue2 = BuyerDBUtil.deleteBookmark(id);
		
		if(isTrue == true && isTrue2 == true) {
			request.setAttribute("success", "Buyer Profile successfully deleted!");
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("error", "Sorry, Buyer delete was unsuccessful!");
			RequestDispatcher dis2 = request.getRequestDispatcher("login.jsp");
			dis2.forward(request, response);
		}
	}

}
