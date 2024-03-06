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

@WebServlet("/DeleteBookmarkServlet")
public class DeleteBookmarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookID = request.getParameter("deleteid");
		
		boolean isTrue;
		
		isTrue = BookmarkDBUtil.deleteBookmark(bookID);
		
		HttpSession session = request.getSession();

		int id = (int) session.getAttribute("user_ID");
		
		List<Bookmark> bookmarkDetails = BookmarkDBUtil.getBookmarks(id);
		request.setAttribute("bookmarkDetails", bookmarkDetails);

		int BID = (int) session.getAttribute("user_ID");

		List<User> buyerDetails = BuyerDBUtil.getBuyer(BID);
		request.setAttribute("buyerDetails", buyerDetails);
		
		if(isTrue == true) {
			request.setAttribute("success", "Bookmark successfully deleted!");
			RequestDispatcher dis = request.getRequestDispatcher("buyer_profile.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("error", "Sorry, Bookmark delete was unsuccessful!");
			RequestDispatcher dis2 = request.getRequestDispatcher("login.jsp");
			dis2.forward(request, response);
		}
		
	}

}
