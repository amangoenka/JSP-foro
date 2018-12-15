<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
    if(session.getAttribute("user")!=null){
            response.sendRedirect("home.jsp");
    }
  %>
<%! String title="Welcome foro"; %>
  <%@ include file="inc/header.jsp" %>
<div class="container" id="body">
  <div class="formbox">
       <% if(session.getAttribute("msg") != null){%>
          <div class="alert alert-warning alert-dismissible fade show" role="alert">
              <strong>Sorry!</strong> <%= session.getAttribute("msg")  %>
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    </div> <% } %>
    <h3 class="formhead">Welcome to foro</h3>
    <form class="form" action="login" method="post">
      <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" required name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
      </div>
      <div class="form-group">
        <a href="index.jsp">I don't have an account</a> <br>
        <a href="forgetpassword.jsp">Forget Password</a>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</div>

<%@ include file="inc/footer.jsp" %>