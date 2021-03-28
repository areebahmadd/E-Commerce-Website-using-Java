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



@WebServlet("/incDecQuantityAction")
public class IncDecQuantityAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email=session.getAttribute("email").toString();
		String id=request.getParameter("id");
		String incdec=request.getParameter("quantity");
		EcommerceDao inde=new EcommerceDao();
		int quantity= inde.incDec(email, id, incdec);
		if(quantity==1 && incdec.equals("dec"))
			{
			RequestDispatcher dispatcher=request.getRequestDispatcher("myCart.jsp?msg=notPossible");
			try {
	    		dispatcher.forward(request, response);
	    	   }
	    	   catch(Exception e)
	    	   {
	    		   e.printStackTrace();
	    	   }
	        }
			
		else if(quantity!=1 && incdec.equals("dec"))
		{
		RequestDispatcher dispatcher=request.getRequestDispatcher("myCart.jsp?msg=dec");
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
			RequestDispatcher dispatcher=request.getRequestDispatcher("myCart.jsp?msg=inc");
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
