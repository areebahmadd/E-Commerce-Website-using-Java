<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html lang="en-GB">
<head>
<link rel="stylesheet" href="css/home-style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title></title>
</head>
    <!--Header-->
    <br>
    <div class="topnav sticky">
            <% String email=session.getAttribute("email").toString(); %>
            <h2 style="text-align:center;">Online shopping</h2>
            <h2><a href=""><% out.println(email);%> <em class='fas fa-user-alt'></em></a></h2>
            <a href="home.jsp">Home<em class="fa fa-institution"></em></a>
            <a href="myCart.jsp">My Cart<em class='fas fa-cart-arrow-down'></em></a>
            <a href="myOrders.jsp">My Orders  <em class='fab fa-elementor'></em></a>
            <a href="logout.jsp">Logout <em class='fas fa-share-square'></em></a>
            <div class="search-container">
             
               <form action="searchHome.jsp" method="post">
               <input type="text" placeholder="Search" name="search">
               <button type="submit"><em class="fa fa-search"></em></button>
               </form>
            </div>
          </div>
           <br>
           <!--table-->
