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


@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password1 = request.getParameter("passwordNew1");
		String password2 = request.getParameter("passwordNew2");
		UsersDAOImpl impl=new UsersDAOImpl();
		if(password1.equals(password2)) {
			int res=impl.ResetPassword(username, password1);
			if(res==0) {
				out.println("<h2>Password Change UnSuccessfull(Old and New Password Same)</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("forgotPassword.html");
				rd.include(request, response);
			}
			else {
				 RequestDispatcher rd = request.getRequestDispatcher("home.html");
					rd.forward(request, response);
			}
		}
		
		else {
			out.println("<h2>Password Change UnSuccessfull(Password and Confirm Password Not same)</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("forgotPassword.html");
			rd.include(request, response);
		}
	}

}
