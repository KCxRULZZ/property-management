package com.PropertyManagementSystem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String password = request.getParameter("psw");
		String userType = request.getParameter("user_type");
		
		boolean isTrue;
		
		isTrue = UserDBUtil.registerUser(name, gender, phone, email, address, dob, password, userType);
		
		if(isTrue == true) {
			request.setAttribute("success", "User successfully registerd!");
			RequestDispatcher dis = request.getRequestDispatcher("register.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("error", "Sorry, user register was unsuccessful!");
			RequestDispatcher dis2 = request.getRequestDispatcher("register.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}
