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
 * Servlet implementation class AddBookmarkServlet
 */
@WebServlet("/AddBookmarkServlet")
public class AddBookmarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String PID = request.getParameter("PID");
		String OID = request.getParameter("OID");
		String pName = request.getParameter("pName");
		String pOwner = request.getParameter("pOwner");
		String pAmount = request.getParameter("pAmount");
		String pLocation = request.getParameter("pLocation");
		String pContact = request.getParameter("pContact");
		
		int cPID = Integer.parseInt(PID);
		int cOID = Integer.parseInt(OID);
		double cpAmount = Double.parseDouble(pAmount);
		
		boolean isTrue;
		
		isTrue = BookmarkDBUtil.addBookmark(cPID, cOID, pName, pOwner, cpAmount, pLocation, pContact);
		
		HttpSession session = request.getSession();
		
		int BID = (int) session.getAttribute("user_ID");
		
		List<Bookmark> bookmarkDetails = BookmarkDBUtil.getBookmarks(BID);
		request.setAttribute("bookmarkDetails", bookmarkDetails);

		List<User> buyerDetails = BuyerDBUtil.getBuyer(BID);
		request.setAttribute("buyerDetails", buyerDetails);
		
		if(isTrue == true) {
			request.setAttribute("success", "Bookmark added!");
			RequestDispatcher dis = request.getRequestDispatcher("buyer_profile.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("error", "Sorry, Bookmark was unsuccessful!");
			RequestDispatcher dis2 = request.getRequestDispatcher("buyer_profile.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}
