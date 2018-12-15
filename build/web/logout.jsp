<%-- 
    Document   : logout.jsp
    Created on : 6 Oct, 2018, 5:47:49 PM
    Author     : niteshwaghmare
--%>

<%  if(session.getAttribute("user") == null ) {  response.sendRedirect("index.jsp");}
                %>
<%! String title = "Thank you"; String user; %>


<%@ include file="inc/header2.jsp" %>
<%
                session.removeAttribute("user");
		session.removeAttribute("msg");
                session.removeAttribute("active");
                session.removeAttribute("msg");
		session.invalidate();
%>
 <div class="container" id="body">
        <div style="margin: 100px auto" class="jumbotron">
            <h1 class="display-4">Thankyou!</h1>
  <p class="lead">"You can do amazing thing if you have strong faith, deep desire and just hang in there."</p>
  <hr class="my-4">
  <p>"Come back agine!"</p>
  <a class="btn btn-primary btn-lg" href="login.jsp" role="button">Back to login</a>
</div>
        </div>
  <%@ include file="inc/footer.jsp" %>
  
    
