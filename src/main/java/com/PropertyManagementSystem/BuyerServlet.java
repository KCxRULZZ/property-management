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
 * Servlet implementation class BuyerServlet
 */
@WebServlet("/BuyerServlet")
public class BuyerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try {

			HttpSession session = request.getSession();

			int BID = (int) session.getAttribute("user_ID");

			List<User> buyerDetails = BuyerDBUtil.getBuyer(BID);
			request.setAttribute("buyerDetails", buyerDetails);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("buyer_profile.jsp");
		dis.forward(request, response);

	}

}
