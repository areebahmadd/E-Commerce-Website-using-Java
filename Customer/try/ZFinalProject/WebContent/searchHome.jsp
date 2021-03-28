<%@page import="dao.ConnectionProvider"%>
<%@page import="dao.EcommerceDao" %>
<%@page import="model.Product" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@include file="header.jsp"%>
<%@include file="footer.jsp"%>
<!DOCTYPE html>
<html lang="en-GB">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<div style="color: white; text-align: center; font-size: 30px;">Home <em class="fa fa-institution"></em></div>
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
int z=0;
String search=request.getParameter("search");
EcommerceDao ec = new EcommerceDao();
ArrayList<Product> arrayList1 = ec.searchhome(search);
for(Product obj1:arrayList1)
{
	z=1;
%>
          <tr>
             <td><%= obj1.getId() %></td>
             <td><%= obj1.getName() %></td>
             <td><%= obj1.getCategory() %></td>
             <td><em class="fa fa-inr"></em><%= obj1.getPrice() %></td>
              <td><a href="addToCartAction?id=<%= obj1.getId() %>">Add to cart <em class='fas fa-cart-plus'></em></a></td>  
          </tr>
 <%
}

%>        
        </tbody>
      </table>
     <% if(z==0)
     {%> 	
	<h1 style="color:white; text-align: center;">Nothing to show</h1>
	<%} %>
      <br>
      <br>
      <br>
      <div class="footer">
          <p>All right reserved by LP12 Batch</p>
      </div>

</body>
</html>