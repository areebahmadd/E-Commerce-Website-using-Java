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



@WebServlet("/signupAction")
public class SignupAction extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{   
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobileNumber=request.getParameter("mobileNumber");
		String securityQuestion=request.getParameter("securityQuestion");
		String answer=request.getParameter("answer");
		String password=request.getParameter("password");
		String address=" ";
		String city=" ";
		String state=" ";
		String country=" ";
		
		Users user=new Users(name,email,mobileNumber,securityQuestion,answer,password,address);
		Users user2=new Users(city,state,country);
		EcommerceDao dt=new EcommerceDao();
		String s= dt.signup(user,user2);
		if("valid".equals(s))
		{
        RequestDispatcher dispatcher=request.getRequestDispatcher("signup.jsp?msg=valid");
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
