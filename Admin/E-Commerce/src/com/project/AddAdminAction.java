package com.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.* ;

@WebServlet("/AddAdminAction")
public class AddAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 String mobileNumber = request.getParameter("mobileNumber");
		 String securityQuestion = request.getParameter("securityQuestion");
		 String answer = request.getParameter("answer");
		 String msg = "";
		 
		 try{
			 Connection con = ConnectionProvider.getCon();
			 PreparedStatement ps = con.prepareStatement("insert into AdminTable values(?,?,?,?,?,?) ");
			 ps.setString(1, name);
			 ps.setString(2, email);
			 ps.setString(3, mobileNumber);
			 ps.setString(4, password);
			 ps.setString(5, securityQuestion);
			 ps.setString(6, answer);
			 
			 int a = ps.executeUpdate();
			 System.out.println(a);
			 
			 request.setAttribute("msg", "Valid");
			 RequestDispatcher dispatcher =  request.getRequestDispatcher("signup.jsp");
			 dispatcher.forward(request, response);
			 
		 }
		 catch(Exception e)
		 {
			 request.setAttribute("msg", "Invalid");
			 RequestDispatcher dispatcher =  request.getRequestDispatcher("signup.jsp");
			 dispatcher.forward(request, response);
			 //System.out.println(e.printStackTrace());
		 }
	}

}
