<%@page import="dao.ConnectionProvider"%>
<%@page import="java.sql.*"%>
<%

try
{
	Connection con=ConnectionProvider.getCon();
	Statement st=con.createStatement();
	//String q1="create table users (name varchar(100),email varchar(100)primary key,mobileNumber number(10),securityQuestion varchar(200),answer varchar(200),password varchar(100),address varchar(500),city varchar(100),state varchar(100),country varchar(100))";
	//String q2="create table product(id number(10),name varchar(500),category varchar(200),price number(10),active varchar(10))";
	//String q3="create table cart(email varchar(100),product_id INTEGER,quantity INTEGER,price INTEGER,total INTEGER,address varchar(500),city varchar(100),state varchar(100),country varchar(100),mobileNumber INTEGER,orderDate varchar(100),deliveryDate varchar(100),paymentMethod varchar(100),transactionId varchar(100),status varchar(10))";
	String q4="create table product(id INTEGER,name varchar(500),category varchar(200),price INTEGER,active varchar(10))";
	//System.out.println(q1);
	//System.out.println(q2);
	//System.out.println(q3);
	//st.execute(q1);
	//st.execute(q2);
	//st.execute(q3);
	st.execute(q4);
	System.out.println("table created....");
	con.close();	
}

catch(Exception e)
{
	System.out.println(e);
}



%>