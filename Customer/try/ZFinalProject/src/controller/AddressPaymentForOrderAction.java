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

import model.Users;




@WebServlet("/addressPaymentForOrderAction")
public class AddressPaymentForOrderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email=session.getAttribute("email").toString();
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String mobileNumber=request.getParameter("mobileNumber");
		String paymentMethod=request.getParameter("paymentMethod");
		String transactionId="";
		transactionId=request.getParameter("transactionId");
		String status="bill";
		Users user1=new Users(email,mobileNumber,address,city,state,country);
		EcommerceDao ap=new EcommerceDao();
		ap.addressPaymentOrder(user1, transactionId, status, paymentMethod);
		RequestDispatcher dispatcher=request.getRequestDispatcher("bill.jsp");
		try {
    		dispatcher.forward(request, response);
    	   }
    	   catch(Exception e)
    	   {
    		   e.printStackTrace();
    	   }
		
		
	}
	

}
