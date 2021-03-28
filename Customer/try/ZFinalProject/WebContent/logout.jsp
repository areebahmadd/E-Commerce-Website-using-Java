<%
session.invalidate();
request.getRequestDispatcher("/login.jsp").forward(request,response);
%>