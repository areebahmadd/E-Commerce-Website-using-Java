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


@WebServlet("/removeFromCart")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email=session.getAttribute("email").toString();
		String productid=request.getParameter("id");
		EcommerceDao ec=new EcommerceDao();
		ec.removeFromCart(email, productid);
		RequestDispatcher dispatcher=request.getRequestDispatcher("myCart.jsp?msg=removed");
	   try {
		dispatcher.forward(request, response);
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	}

}
