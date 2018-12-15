<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! String title="foro inc."; %>
  <%@ include file="inc/header.jsp" %>
  <% 
    if(session.getAttribute("user")!=null){
            response.sendRedirect("home.jsp");
    }
    {
        
    }
  %>
<div class="container" id="body">
    <% if(session.getAttribute("active") != null ){ %>
    <div class="alert alert-warning"  style="margin-top: 20px;" id="active" role="alert">
        <%= "Please verify your account verification link sent you email address" %>
    </div>
    <% } %>
  <div class="formbox">
      <% if(session.getAttribute("msg") != null){%>
          <div class="alert alert-warning alert-dismissible fade show" role="alert">
              <strong>Sorry!</strong> <%= session.getAttribute("msg")  %>
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    </div> <% } %>
        
    <h3 class="formhead">Create a foro account</h3>
    <p class="" style="text-align: center;">It's free and always will be.</p>
    <form class="form" action="register" method="post">
      <div class="form-group">
        <label for="exampleInputEmail1">Full name</label>
        <input type="text" name="name" required class="form-control" id="exampleInputText1" aria-describedby="textHelp" placeholder="Enter Name">
      </div>
      <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" name="email" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" name="password" required class="form-control" id="exampleInputPassword1" placeholder="Password">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Confirm Password</label>
        <input type="password" required class="form-control" id="exampleInputPassword1" placeholder="Password">
      </div>
      <div class="form-group">
        <a href="login.jsp">I already have account</a> <br>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</div>
<%@ include file="inc/footer.jsp" %>
