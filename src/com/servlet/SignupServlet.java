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


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int uid = Integer.parseInt(request.getParameter("uid"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		UsersDAOImpl impl=new UsersDAOImpl();
		User u=new User();
		u.setUser_id(uid);
		u.setFirst_name(fname);
		u.setLast_name(lname);
		u.setUsername(username);
		u.setPassword(password);
		u.setEmail_id(email);
		u.setContact(contact);
		u.setAddress(address);
		int res=impl.Register(u);
		if(res==0) {
			out.println("<h2>SignUp UnSuccessfull</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("signup.html");
			rd.include(request, response);
		}
		else {
			 RequestDispatcher rd = request.getRequestDispatcher("home.html");
				rd.forward(request, response);
		}
		
		
		
	}

}
