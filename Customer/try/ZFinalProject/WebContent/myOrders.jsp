<%@page import="dao.ConnectionProvider"%>
<%@page import="java.sql.*"%>
<%@page import="dao.EcommerceDao" %>
<%@page import="java.util.*" %>
<%@include file="header.jsp"%>
<%@include file="footer.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-GB">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<div style="color: white; text-align: center; font-size: 30px;">My Orders <em class='fab fa-elementor'></em></div>
<table>
<caption>My Orders</caption>
        <thead>
          <tr>
            <th scope="col">S.No</th>
            <th scope="col">Product Name</th>
            <th scope="col">category</th>
            <th scope="col"><em class="fa fa-inr"></em>  Price</th>
            <th scope="col">Quantity</th>
            <th scope="col"><em class="fa fa-inr"></em> Sub Total</th>
            <th scope="col">Order Date</th>
             <th scope="col">Expected Delivery Date</th>
             <th scope="col">Payment Method</th>
              <th scope="col">Status</th>
              
          </tr>
        </thead>
        <tbody>
<%
int sno=0;
EcommerceDao mc= new EcommerceDao();
List dataList=mc.myorders(email);

for (int i=0;i<dataList.size() ;i=i+9)
{
	sno=sno+1;

%>
          <tr>
            <td><%out.println(sno); %></td>
            <td><%=dataList.get(i) %></td>
            <td><%=dataList.get(i+1) %></td>
            <td><em class="fa fa-inr"></em> <%=dataList.get(i+2) %></td>
            <td><%=dataList.get(i+3) %></td>
            <td><em class="fa fa-inr"></em><%=dataList.get(i+4) %> </td>
             <td><%=dataList.get(i+5) %></td>
              <td><%=dataList.get(i+6) %></td>
               <td><%=dataList.get(i+7) %></td>
               <td><%=dataList.get(i+8) %></td>
 <%
}

%>           </tr>
         
        </tbody>
      </table>
      <br>
      <br>
      <br>

</body>
</html>