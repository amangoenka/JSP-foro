<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String title="Forgetpassword"; %>
  <%@ include file="inc/header.jsp" %>
<div class="container" id="body">
      <div class="formbox">
        <h3 class="formhead">Forgot password</h3>
        <form class="" action="index.html" method="post">
      <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
      </div>
      <div class="form-group">
        <a href="index.jsp">I don't have an account</a> <br>
        <a href="login.jsp">Back to login page</a><br>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
      </form>
       
      </div>
    </div>

<%@ include file="inc/footer.jsp" %>