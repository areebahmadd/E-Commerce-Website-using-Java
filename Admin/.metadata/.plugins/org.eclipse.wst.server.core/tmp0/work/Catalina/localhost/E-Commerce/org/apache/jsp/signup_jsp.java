/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2021-01-07 12:56:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/signup-style.css\">\r\n");
      out.write("<title>Signup</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id='container'>\r\n");
      out.write("  <div class='signup'>\r\n");
      out.write("  <form action =\"AddAdminAction\" method = \"post\">\r\n");
      out.write("  <input type = \"text\" name = \"name\" placeholder = \"Enter Name\" required>\r\n");
      out.write("  <input type = \"email\" name = \"email\" placeholder = \"Enter email\" required>\r\n");
      out.write("  <input type = \"number\" name = \"mobileNumber\" placeholder = \"Enter Mobile Number\" required>\r\n");
      out.write("  <input type = \"password\" name = \"password\" placeholder = \"Enter password\" required>\r\n");
      out.write("  <select name = \"securityQuestion\" required>\r\n");
      out.write("  \t<option value = \"What was your first car?\">What was your first car?</option>\r\n");
      out.write("  \t<option value = \"What is the name of your first pet?\">What is the name of your first pet?</option>\r\n");
      out.write("  \t<option value = \"What elementary school did you attend?\">What was your first car?</option>\r\n");
      out.write("  \t<option value = \"What is the name of the town where you were born?\">What is the name of the town where you were born?</option>\r\n");
      out.write("  </select>\r\n");
      out.write("  <input type = \"text\" name = \"answer\" placeholder = \"Enter Your Answer\" required>\r\n");
      out.write("  <input type = \"submit\" value = \"signup\">\r\n");
      out.write(" \r\n");
      out.write("  </form>\r\n");
      out.write("    \r\n");
      out.write("      <h2><a href=\"\">Login</a></h2>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class='whysign'>\r\n");
      out.write("  ");
 
String msg=(String)request.getParameter("msg");
if("Valid".equals(msg))
{

      out.write("\t\r\n");
      out.write("<h1>Successfully Registered !!!!!!</h1>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
 
if("Invalid".equals(msg))
{

      out.write("\r\n");
      out.write("<h1>Some thing Went Wrong! Try Again !</h1>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <h2>Online Shopping</h2>\r\n");
      out.write("    <p>The Online Shopping System is the application that allows the users to shop online without going to the shops to buy them.</p>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
