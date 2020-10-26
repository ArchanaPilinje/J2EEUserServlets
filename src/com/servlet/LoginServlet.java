package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.UsersDAOImpl;
import com.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsersDAOImpl impl=new UsersDAOImpl();
		 User u1=impl.login(username,password);
		 if(u1.getUser_id()==0) {
			 out.println("<h2>Login Not Successfull</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
		 }
		 else {
			 RequestDispatcher rd = request.getRequestDispatcher("home.html");
				rd.forward(request, response);
		 }
	}

}
