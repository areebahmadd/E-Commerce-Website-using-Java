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



@WebServlet("/continueShopping")
public class ContinueShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email=session.getAttribute("email").toString();
		String status="processing";
		EcommerceDao cs=new EcommerceDao();
	
		cs.continueShopping(email, status);
		RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
		 try {
				dispatcher.forward(request, response);
			   }
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
		
	}

}
