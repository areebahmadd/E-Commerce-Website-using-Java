<%@page import="dao.ConnectionProvider"%>
<%@page import="dao.EcommerceDao" %>
<%@page import="model.Product" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@include file="header.jsp"%>
<%@include file="footer.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-GB">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
h3
{
	color: yellow;
	text-align: center;
}
</style>
</head>
<body>
<div style="color: white; text-align: center; font-size: 30px;">Home <em class="fa fa-institution"></em></div>

<%
String msg=request.getParameter("msg");
if("added".equals(msg))
{
%>
<h3 class="alert">Product added successfully!</h3>
<%} %>


<%
if("exist".equals(msg))
{
%>
<h3 class="alert">Product already exist in you cart! Quantity  increased!</h3>
<%} %>


<%
if("invalid".equals(msg))
{
%>
<h3 class="alert">Something went wrong...Try Again !!!!</h3>
<%} %>
<table>
<caption></caption>
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Category</th>
            <th scope="col"><em class="fa fa-inr"></em> Price</th>
            <th scope="col">Add to cart <em class='fas fa-cart-plus'></em></th>
          </tr>
        </thead>
        <tbody>

<%
EcommerceDao ec = new EcommerceDao();
ArrayList<Product> arrayList = ec.home();
for(Product obj:arrayList)
{
%>
<tr>
    <td><%= obj.getId() %></td>
    <td><%= obj.getName() %></td>
    <td><%= obj.getCategory() %></td>
    <td><em class="fa fa-inr"></em><%= obj.getPrice() %></td>
    <td><a href="addToCartAction?id=<%= obj.getId() %>">Add to cart <em class='fas fa-cart-plus'></em></a></td>
</tr>

<% 
}
%>
        </tbody>
      </table>
      <br>
      <br>
      <br>

</body>
</html>