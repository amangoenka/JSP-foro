<%-- 
    Document   : error.jsp
    Created on : 6 Oct, 2018, 5:49:41 PM
    Author     : niteshwaghmare
--%>

 <%@ include file="inc/header.jsp" %>
 <%! String title = "Oops!"; %>
 <div class="container" id="body">
            <div style="margin: 190px auto" class=" alert-danger jumbotron jumbotron-fluid">
                <div class="container">
                <h1 class="display-4">Sorry!</h1>
                <p class="lead"> <%= session.getAttribute("msg") %></p>
                <hr>
                <a class="btn btn-primary" href="login.jsp" >Back to login page</a>
                </div>
            </div>
        </div>
 <%@ include file="inc/footer.jsp" %>
