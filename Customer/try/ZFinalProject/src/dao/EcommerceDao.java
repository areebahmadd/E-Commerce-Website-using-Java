package dao;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectionProvider;
import model.Cart;

import model.Product;
import model.Users;

public class EcommerceDao {
	Connection con=ConnectionProvider.getCon();
	 PreparedStatement ps=null;
	   PreparedStatement ps1=null;
	   Statement st=null;
	public void addressPaymentOrder(Users user1,String transactionId,String status,String paymentMethod)
	{ 
		try
		{
		
		ps=con.prepareStatement("update users set address=?,city=?,state=?,country=?,mobileNumber=? where email=?");
		ps.setString(1,user1.getAddress());
		ps.setString(2,user1.getCity());
		ps.setString(3,user1.getState());
		ps.setString(4,user1.getCountry());
		ps.setString(5,user1.getMobileNumber());
		ps.setString(6,user1.getEmail());
		ps.executeUpdate();
		ps1=con.prepareStatement("update cart set address='"+user1.getAddress()+"',city='"+user1.getCity()+"',state='"+user1.getState()+"',country='"+user1.getCountry()+"',mobileNumber='"+user1.getMobileNumber()+"',orderDate=sysdate,deliveryDate=sysdate+7,paymentMethod='"+paymentMethod+"',transactionId='"+transactionId+"',status='"+status+"' where email='"+user1.getEmail()+"' and address is NULL");
		ps1.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		     	
		}
		finally
		{
			try {
				if(ps!=null)
				   {ps.close();}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
			
				if(ps1!=null)
				   {ps1.close();}
				con.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	
	
	
	
	
	
	public int addToCart(String email,String productid)
	{
		int quantity=1;
		int productprice=0;
		int producttotal=0;
		int carttotal=0;
		int z=0;
		try
		{
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from product where id='"+productid+"' ");
		while(rs.next())
		{
			productprice=rs.getInt(4);
			producttotal=productprice;
		}
		ResultSet rs1=st.executeQuery("select * from cart where product_id='"+productid+"' and email='"+email+"' and address is NULL");
		while(rs1.next())
		{
		 carttotal=rs1.getInt(5);
		 carttotal=carttotal+producttotal;
		 quantity=rs1.getInt(3);
		 quantity=quantity+1;
		 z=1;
		}
		if(z==1)
		{
		   st.executeUpdate("update cart set total='"+carttotal+"' , quantity='"+quantity+"' where product_id='"+productid+"' and email='"+email+"' and address is NULL");
		   
		}

		if(z==0)
		{
		ps=con.prepareStatement("insert into cart(email,product_id,quantity,price,total) values (?,?,?,?,?)");	
		ps.setString(1,email);
		ps.setString(2,productid);
		ps.setInt(3,quantity);
		ps.setInt(4,productprice);
		ps.setInt(5,producttotal);
		ps.executeUpdate();
		
		}
		}

		catch(Exception e)
		{   z=2;
			e.printStackTrace();
			}
		finally
		{
			try {
				if(ps!=null)
				   ps.close();
				
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(st!=null)
				   st.close();
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	return z;
	}
	
	
	
	
	
	
	
	
	public void continueShopping(String email,String status)
	{  
		try
		{
		    ps=con.prepareStatement("update cart set status=? where email=?");
			ps.setString(1,status);	
			ps.setString(2,email);	
		    ps.executeUpdate();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps!=null)
				   ps.close();
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	
	
	
	
	
	
	
	public int forgotpassword(Users use)
	{
		int check=0;
		try
		{
			
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from users where email='"+use.getEmail()+"' and mobileNumber='"+use.getMobileNumber()+"'and securityQuestion='"+use.getSecurityQuestion()+"' and answer='"+use.getAnswer()+"'");
			while(rs.next())
			{   check=1;
			st.executeUpdate("update users set password ='"+use.getPassword()+"' where email='"+use.getEmail()+"' ");
			}
		}

		catch(Exception e)
		{
			check=2;
			e.printStackTrace();

		}
		finally
		{
			try {
				if(st!=null)
				   st.close();
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
	
	
	
	
	
	
	
	public int incDec(String email,String id,String incdec) {
		
		int price=0;
		int total=0;
		int quantity=0;
		String s="and address is NULL";
		try
		{
		
		st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from cart where email='"+email+"' and product_id='"+id+"'" + s);
		while(rs.next())
		{
			price = rs.getInt(4);
			total=rs.getInt(5);
			quantity=rs.getInt(3);
		}
		
		
		
		if(quantity!=1 && incdec.equals("dec"))
		{
		total=total-price;
		quantity=quantity-1;
		st.executeUpdate("update cart set total='"+total+"' ,quantity='"+quantity+"' where email='"+email+"'and product_id='"+id+"'" + s);
		
		}
		else if(incdec.equals("inc"))
		{
			total=total+price;
			quantity=quantity+1;
			st.executeUpdate("update cart set total='"+total+"' ,quantity='"+quantity+"' where email='"+email+"' and product_id='"+id+"'"+s);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				if(st!=null)
				   st.close();
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return quantity;
		}
	
	
	
	
	
	
	
	
	public int login(String email,String password)
	{
	int check=0;

	try
	{   st= con.createStatement();
		ResultSet rs=st.executeQuery("select * from users where email='"+email+"' and password='"+password+"'");
		while(rs.next())
		{  
			
			check=1;
			
		}
	
	}
	
	catch(Exception e)
	{
		check=2;
		e.printStackTrace();
		
		
	}
	finally
	{
		try {
			if(st!=null)
		    st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return check;
	}
	
	
	
	
	
	
	
	
	public void removeFromCart(String email,String productid)
	{
		try
		{
			st=con.createStatement();
			st.executeUpdate("delete from cart where email='"+email+"' and product_id='"+productid+"' and address is NULL");
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				if(st!=null)
				   st.close();
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	public String signup(Users user,Users user2)
	{
	    String s=" ";
	try
	{
	
    ps=con.prepareStatement("insert into users values(?,?,?,?,?,?,?,?,?,?)");
	ps.setString(1,user.getName());
	ps.setString(2,user.getEmail());
	ps.setString(3,user.getMobileNumber());
	ps.setString(4,user.getSecurityQuestion());
	ps.setString(5,user.getAnswer());
	ps.setString(6,user.getPassword());
	ps.setString(7,user.getAddress());
	ps.setString(8,user2.getCity());
	ps.setString(9,user2.getState());
	ps.setString(10,user2.getCountry());
	ps.executeUpdate();
    s="valid";
	}

	catch(Exception e)
	{
		e.printStackTrace();
	    s="invalid";
	}
	
	finally
	{
		try {
			if(ps!=null)
			   ps.close();
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	return s;
	}
	
	
	
	
	public ArrayList<Product> home()
	{   
		ArrayList<Product> arrayList=new ArrayList<>();
		try
	    {st=con.createStatement();
		ResultSet rs=st.executeQuery("select *from product where active='Yes'");
		while(rs.next())
		{
			Product pro=new Product();
			pro.setId(rs.getString(1));
		    pro.setName(rs.getString(2));
		    pro.setCategory(rs.getString(3));
		    pro.setPrice(rs.getString(4));
		    arrayList.add(pro);
		}
	    }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return arrayList;	
	}
	
	
	
	
	
	public ArrayList<Product> searchhome(String search)
	{   
		ArrayList<Product> arrayList1=new ArrayList<>();
		try
	    {st=con.createStatement();
		ResultSet rs=st.executeQuery("select *from product where name like '"+search+"' or category like '"+search+"' and active='Yes'");
		while(rs.next())
		{
			Product pro=new Product();
			pro.setId(rs.getString(1));
		    pro.setName(rs.getString(2));
		    pro.setCategory(rs.getString(3));
		    pro.setPrice(rs.getString(4));
		    arrayList1.add(pro);
		}
	    }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return arrayList1;	
	}
	
	
	

	
	 /*  public int  mycarttotal(String email)
	   {  int total=0;
		   try
		   {
		   	
		   	st=con.createStatement();
		   	ResultSet rs1=st.executeQuery("select sum(total) from cart where email='"+email+"' and address is NULL ");
		   			while(rs1.next())
		   			{
		   				total=rs1.getInt(1);
		   			}
	   
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return total;
		   
	   }
*/
	   public List mycart(String email)
		{
			List dataList= new ArrayList();
			
		
		try {
			
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from product inner join cart on product.id=cart.product_id and cart.email='"+email+"' and cart.address is NULL");
			 while(rs.next())
			 {
				 dataList.add(rs.getString(1));
				 dataList.add(rs.getString(2));
				 dataList.add(rs.getString(3));
				 dataList.add(rs.getString(4));
				 dataList.add(rs.getString(8));
				 dataList.add(rs.getString(10));
			 }
	  
		}
		
		catch(Exception e)
		 {
			 System.out.println(e);
		 }
		
		return dataList;
		}

	   
	   public List myorders(String email)
	   {
		   List dataList= new ArrayList();
		   try
		   {
		  
		    st=con.createStatement();
		   ResultSet rs=st.executeQuery("select * from cart inner join product on cart.product_id=product.id and cart.email='"+email+"' and cart.orderDate is not NULL");
		   while(rs.next())
		   { 
			   dataList.add(rs.getString(17));
				 dataList.add(rs.getString(18));
				 dataList.add(rs.getString(19));
				 dataList.add(rs.getString(3));
				 dataList.add(rs.getString(5));
				 dataList.add(rs.getString(11)); 
				 dataList.add(rs.getString(12));
				 dataList.add(rs.getString(13));
				 dataList.add(rs.getString(15));
				 
		   }
		   }
		   catch(Exception e)
		   {
		   	System.out.println(e);
		   	}
		   return dataList;
	   }
	   
	   
	   public List addresspayment(String email)
	   {
		   List dataList1= new ArrayList();
		   try
		   {
		  
		    st=con.createStatement();
		    ResultSet rs=st.executeQuery("select * from product inner join cart on product.id=cart.product_id and cart.email='"+email+"' and cart.address is NULL");
		   while(rs.next())
		   { 
			   dataList1.add(rs.getString(2));
				 dataList1.add(rs.getString(3));
				 dataList1.add(rs.getString(4));
				 dataList1.add(rs.getString(8));
				 dataList1.add(rs.getString(10));
			
				 
		   }
		   }
		   catch(Exception e)
		   {
		   	System.out.println(e);
		   	}
		   return dataList1;  
		   
		   
	   }
	
	   public List addresspayment1(String email)
	   {
		   List dataList2= new ArrayList();
		   try
		   {
		  
		    st=con.createStatement();
		    ResultSet rs=st.executeQuery("select * from users where email='"+email+"' ");
		   while(rs.next())
		   { 
			   dataList2.add(rs.getString(7));
				 dataList2.add(rs.getString(8));
				 dataList2.add(rs.getString(9));
				 dataList2.add(rs.getString(10));
				 dataList2.add(rs.getString(3));
			
				 
		   }
		   }
		   catch(Exception e)
		   {
		   	System.out.println(e);
		   	}
		   return dataList2;  
		   
		   
	   }
}
