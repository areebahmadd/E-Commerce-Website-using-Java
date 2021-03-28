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




@WebServlet("/addToCartAction")
public class AddToCartAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email=session.getAttribute("email").toString();
		String id=request.getParameter("id");
		EcommerceDao ac=new EcommerceDao();
		int s=ac.addToCart(email,id);
		if(s==1)
		{
		   
		   RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp?msg=exist");
		   try {
				dispatcher.forward(request, response);
			   }
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
		}

		else if (s==0)
		{
	
		RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp?msg=added");
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
			RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp?msg=invalid");
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
