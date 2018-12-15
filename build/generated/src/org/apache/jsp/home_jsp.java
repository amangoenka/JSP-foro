package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String title="foro inc. | home"; 
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/inc/header.jsp");
    _jspx_dependants.add("/inc/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write(' ');
 
     response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
     response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
     response.setHeader("Expires", "0"); // Proxies. 
    if(session.getAttribute("user")== null){
            response.sendRedirect("index.jsp");
    }
  
      out.write('\n');
      out.write("\n");
      out.write("  ");
      out.write("\n");
      out.write("    \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <title>");
      out.print( title );
      out.write("</title>\n");
      out.write("  <link rel=\"icon\" href=\"img/icon.png\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=PT+Sans:400,700\" rel=\"stylesheet\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <div class=\"\" id=\"container\">\n");
      out.write("    <!-- Nav bar -->\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("      <a class=\"navbar-brand\" href=\"index.jsp\">foro</a>\n");
      out.write("      <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("      </button>\n");
      out.write("      \n");
      out.write("      <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("        <ul style=\"padding-left: 30px;\" class=\"navbar-nav mr-auto\">\n");
      out.write("          <li class=\"nav-item active\">\n");
      out.write("          ");
 if(session.getAttribute("user") != null) {
      out.write("\n");
      out.write("            <a class=\"nav-link\" href=\"home.jsp\">Home <span class=\"sr-only\">(current)</span></a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a class=\"nav-link\" href=\"mythreads.jsp\">My Threads</a>\n");
      out.write("          </li>\n");
      out.write("        </ul>\n");
      out.write("        <ul class=\"navbar-nav my-lg-0\">\n");
      out.write("          <li class=\"nav-item dropdown\">\n");
      out.write("            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("            <i class=\"fas fa-user-circle\"></i> Hi ");
      out.print( session.getAttribute("user") );
      out.write("\n");
      out.write("            </a>\n");
      out.write("            <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("              <a class=\"dropdown-item\" href=\"#\">Profile</a>\n");
      out.write("              <div class=\"dropdown-divider\"></div>\n");
      out.write("              <a class=\"dropdown-item\" href=\"logout.jsp\">Logout</a>\n");
      out.write("            </div>\n");
      out.write("          </li>\n");
      out.write("        </ul>\n");
      out.write("         ");
} 
      out.write("\n");
      out.write("      </div>\n");
      out.write("      </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("<div class=\"container\" style=\"width: 70%; align-items: center; justify-content: center\" id=\"body\">\n");
      out.write("    ");
 if(session.getAttribute("active") != null ){ 
      out.write("\n");
      out.write("    <div class=\"alert alert-dark\"  style=\"margin-top: 20px;\" id=\"active\" role=\"alert\">\n");
      out.write("        ");
      out.print( "Please verify your account verification link sent you email address" );
      out.write("\n");
      out.write("    </div>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("  <form class=\"\">\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("      <label for=\"formGroupExampleInput2\" class=\"shead\">Search threads</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"formGroupExampleInput2\" placeholder=\"\">\n");
      out.write("      <button type=\"submit\" id=\"search\" class=\"btn btn-dark\">Search</button>\n");
      out.write("    </div>\n");
      out.write("  </form>\n");
      out.write("  <hr>\n");
      out.write("  <div class=\"tag-table\">\n");
      out.write("    <ul class=\"tags\">\n");
      out.write("      <li><a href=\"bytopic.jsp?topic=Technology\"><span id=\"tag\" class=\"badge badge-warning\">Technology</span></a></li>\n");
      out.write("      <li><a href=\"bytopic.jsp?topic=Social\"><span id=\"tag\" class=\"badge badge-warning\">Social</span></a></li>\n");
      out.write("      <li><a href=\"bytopic.jsp?topic=Health\"><span id=\"tag\" class=\"badge badge-warning\">Health</span></a></li>\n");
      out.write("      <li><a href=\"bytopic.jsp?topic=Political\"><span id=\"tag\" class=\"badge badge-warning\">Political</span></a></li>\n");
      out.write("      <li><a href=\"bytopic.jsp?topic=Sports\"><span id=\"tag\" class=\"badge badge-warning\">Sports</span></a></li>\n");
      out.write("      <li><a href=\"bytopic.jsp?topic=Environment\"><span id=\"tag\" class=\"badge badge-warning\">Environment</span></a></li>\n");
      out.write("      <li><a href=\"bytopic.jsp?topic=Others\"><span id=\"tag\" class=\"badge badge-warning\">Others</span></a></li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("  <hr>\n");
      out.write("  <h2 class=\"\" style=\"font-weight: bold\">Trending</h2>\n");
      out.write("  <div class=\"\">\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("  <a class=\"question\" href=\"thread.jsp\">\n");
      out.write("    <div class=\"threads\">\n");
      out.write("      <p class=\"topic\"> <b>Topic: </b>Health</p>\n");
      out.write("      <h2 class=\"thread\">What daliy routie dite everyone should own?</h2>\n");
      out.write("      <p class=\"by\"><b>By </b>Aman Goenka <b>Posted on</b> 20/09/2018</p>\n");
      out.write("      <p class=\"answers\"> <b>40 Answers</b> </p>\n");
      out.write("      <div class=\"votes\">\n");
      out.write("        <button type=\"button\" class=\"btn btn-outline-success btn-sm\">12 Upvote</button> <button type=\"button\" class=\"btn btn-outline-danger btn-sm\">2 Downvote</button>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </a>\n");
      out.write("  <div class=\"pages\">\n");
      out.write("    <nav aria-label=\"Page navigation example\">\n");
      out.write("      <ul class=\"pagination justify-content-center\">\n");
      out.write("        <li class=\"page-item disabled\">\n");
      out.write("          <a class=\"page-link\" href=\"#\" tabindex=\"-1\">Previous</a>\n");
      out.write("        <li class=\"page-item active\"><a class=\"page-link\" href=\"#\">1</a></li>\n");
      out.write("        <li class=\"page-item\"><a class=\"page-link\" href=\"#\">2</a></li>\n");
      out.write("        <li class=\"page-item\"><a class=\"page-link\" href=\"#\">3</a></li>\n");
      out.write("        <li class=\"page-item\">\n");
      out.write("          <a class=\"page-link\" href=\"#\">Next</a>\n");
      out.write("        </li>\n");
      out.write("      </ul>\n");
      out.write("    </nav>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"\" id=\"footer\">\n");
      out.write("      <p class=\"copy\">Copyright &copy 2018 foro</p>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</body>\n");
      out.write("<script src=\"js/jquery-3.3.1.min.js\" charset=\"utf-8\"></script>\n");
      out.write("<script src=\"js/bootstrap.min.js\" charset=\"utf-8\"></script>\n");
      out.write("</html>");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
