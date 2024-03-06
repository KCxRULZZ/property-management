package com.PropertyManagementSystem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
            List<User> userDetails = UserDBUtil.validate(email, password);
            
            if ("admin@gmail.com".equals(email) && "admin@123".equals(password)) {
                // Admin login
                HttpSession session = request.getSession();
                session.setAttribute("user_email", "admin@gmail.com");
                session.setAttribute("user_ID", "0");
                session.setAttribute("user_name", "Admin");
                session.setAttribute("account", "admin");
                
                List<User> buyerDetails = UserDBUtil.getAllBuyers();
  				request.setAttribute("buyerDetails", buyerDetails);
  				
  				List<User> sellerDetails = UserDBUtil.getAllSellers();
  				request.setAttribute("sellerDetails",sellerDetails );
  				
  				List<Payment> paymentDetails = PaymentDBUtile.getAllPayment();
  				request.setAttribute("paymentDetails", paymentDetails);
  				
                // Forward to admin_profile.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("admin_profile.jsp");
                dispatcher.forward(request, response);
                
                return;
            }

            if (userDetails != null && !userDetails.isEmpty()) {
                User user = userDetails.get(0);

                HttpSession session = request.getSession();
                session.setAttribute("user_email", user.getEmail());
                session.setAttribute("user_ID", user.getId());
                session.setAttribute("user_name", user.getName());
                session.setAttribute("user_phone", user.getPhone());

                //check if buyer or seller
                if ("Buyer".equals(user.getType())) {
                    session.setAttribute("account", "Buyer");
                    response.sendRedirect("index.jsp");
                    
                } else if ("Seller".equals(user.getType())) {
                    session.setAttribute("account", "Seller");
                    response.sendRedirect("index.jsp");
                }
            } else {
                // Invalid user, display an error message
                request.setAttribute("error", "Invalid email or password. Please try again.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
