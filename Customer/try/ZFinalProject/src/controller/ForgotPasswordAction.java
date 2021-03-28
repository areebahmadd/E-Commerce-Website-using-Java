package controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EcommerceDao;
import model.Users;


@WebServlet("/forgotPasswordAction")
public class ForgotPasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("email");
		String mobileNumber=request.getParameter("mobileNumber");
		String securityQuestion=request.getParameter("securityQuestion");
		String answer=request.getParameter("answer");
		String newpassword=request.getParameter("newpassword");
		 Users use=new Users(email,mobileNumber,securityQuestion,answer,newpassword);
		 EcommerceDao fp=new EcommerceDao();
		   int check=fp.forgotpassword(use);
		 
		    if(check==1)
			{   
		    	RequestDispatcher dispatcher=request.getRequestDispatcher("forgotPassword.jsp?msg=done");
				 try {
						dispatcher.forward(request, response);
					   }
					   catch(Exception e)
					   {
						   e.printStackTrace();
					   }
				
			}
		    else if(check==0)
			{
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("forgotPassword.jsp?msg=invalid");
				 try {
						dispatcher.forward(request, response);
					   }
					   catch(Exception e)
					   {
						   e.printStackTrace();
					   }
			}
		

	     else
		{
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp?msg=invalid");
			 try {
					dispatcher.forward(request, response);
				   }
				   catch(Exception e)
				   {
					   e.printStackTrace();
				   }
			
		}

	}

}
