package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.EcommerceDao;


@WebServlet("/loginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{   HttpSession session=request.getSession();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		EcommerceDao ld=new EcommerceDao();
			int check = ld.login(email, password);
				if(check==1)
				{   
					session.setAttribute("email",email);
					RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
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
					RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp?msg=notexist");
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
				RequestDispatcher dispatcher=request.getRequestDispatcher("signup.jsp?msg=invalid");
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
