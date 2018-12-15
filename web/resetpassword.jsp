<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String title="Resetpassword"; %>
  <%@ include file="inc/header.jsp" %>
<div class="container" id="body">
  <div class="formbox">
    <h3 class="formhead">Reset Password</h3>
    <form class="" action="index.html" method="post">
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Confirm Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</div>
<%@ include file="inc/footer.jsp" %>
