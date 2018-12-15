<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setHeader("Expires", "0"); // Proxies.
    if(session.getAttribute("user")== null){
            response.sendRedirect("index.jsp");
   }
%>
<%! String title="Thread";%>
<%@ include file="inc/header.jsp" %>
<div class="container" id="body">
    <% if(session.getAttribute("active") != null ){ %>
    <div class="alert alert-warning"  style="margin-top: 20px;" id="active" role="alert">
        <%= "Please verify your account verification link sent you email address" %>
    </div>
    <% } %>
  <div class="threads">
      <% int id = Integer.parseInt(request.getParameter("id")); %>
    <%
        String url ="jdbc:mysql://localhost:8889/class";
        String usr ="root";
        String pass= "root";
        String query = "select * from posts where post_id="+id;
        System.out.println(query);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,usr,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.equals("null"))
            {
              session.setAttribute("msg","Something went worng");
              response.sendRedirect("error.jsp");
            } rs.next(); %>
    <p class="topic"> <b>Topic: </b> <%= rs.getString("catagory_name") %> </p>
    <h2 class="thread"><%= rs.getString("post_title") %> </h2>
    <p class="descrption"><%= rs.getString("post_desc") %></p>
    <p class="by"><b>By </b><%= rs.getString("user_name") %><b> Posted on</b> <%= rs.getString("post_ts") %></p>
    <div class="votes">
      <button type="button" class="btn btn-outline-success btn-sm">12 Upvote</button> <button type="button" class="btn btn-outline-danger btn-sm">2 Downvote</button>
    </div>
  </div>
  <% }catch(Exception e)
        {
          session.setAttribute("msg",e);
          response.sendRedirect("error.jsp");
        }
    %>
  <hr>
  <h5><b>Responses:</b></h5>
  <form class="" action="savecomments" method="post" style="width: 60%; margin: auto;">
    <div class="form-group">
      <label for="exampleFormControlTextarea1">Enter your Thoughts</label>
      <textarea class="form-control" name="comment" id="exampleFormControlTextarea1" rows="4"></textarea>
      <input type="text" name="user_name" value="<%= session.getAttribute("user") %>" style="display: none">
      <input type="text" name="id" value="<%= id %>" style="display: none">
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-primary" name="Submit">Submit</button>
    </div>
  </form>
  <hr>
  <div class="thoughts">
        <%

        String commentsquery = "select * from replies where post_id="+id;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,usr,pass);
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery(commentsquery);
            if(rs1.equals("null"))
            {
              System.out.println("Result nothing");
            }
      while(rs1.next()){ %>
    <div class="comment">
        <p class="by" style="color: rgb(10, 10, 10);"> <b><%= rs1.getString("user_name") %>  </b>  <br>  <span>Replies on </span> <%= rs1.getString("reply_ts") %> </p>
      <p><%= rs1.getString("reply_desc") %></p>
      <button type="button" class="btn btn-outline-primary btn-sm">Like</button>
    </div>
      <% } }catch(Exception e)
        {
          System.out.println(e);
        }
    %>
  </div>
</div>

<%@ include file="inc/footer.jsp" %>
