<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
 <% 
     response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
     response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
     response.setHeader("Expires", "0"); // Proxies. 
    if(session.getAttribute("user")== null){
            response.sendRedirect("index.jsp");
    }
  %>
<%! String title="foro inc. | home"; %>
  <%@ include file="inc/header.jsp" %>
<div class="container" style="width: 70%; align-items: center; justify-content: center" id="body">
    <% if(session.getAttribute("active") != null ){ %>
    <div class="alert alert-warning"  style="margin-top: 20px;" id="active" role="alert">
        <%= "Please verify your account verification link sent you email address" %>
    </div>
    <% } %>
    <form class="">
    <div class="form-group">
      <label for="formGroupExampleInput2" class="shead">Search threads</label>
      <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="">
      <button type="submit" id="search" class="btn btn-dark">Search</button>
    </div>
  </form>
  <hr>
  <div class="tag-table">
    <ul class="tags">
      <li><a href="bytopic.jsp?topic=Techinical"><span id="tag" class="badge badge-warning">Technology</span></a></li>
      <li><a href="bytopic.jsp?topic=Social"><span id="tag" class="badge badge-warning">Social</span></a></li>
      <li><a href="bytopic.jsp?topic=Health"><span id="tag" class="badge badge-warning">Health</span></a></li>
      <li><a href="bytopic.jsp?topic=Political"><span id="tag" class="badge badge-warning">Political</span></a></li>
      <li><a href="bytopic.jsp?topic=Sports"><span id="tag" class="badge badge-warning">Sports</span></a></li>
      <li><a href="bytopic.jsp?topic=Environment"><span id="tag" class="badge badge-warning">Environment</span></a></li>
      <li><a href="bytopic.jsp?topic=Others"><span id="tag" class="badge badge-warning">Others</span></a></li>
    </ul>
  </div>
  <hr>
  <h2 class="" style="font-weight: bold">Trending</h2>
  <div class="">

  </div>
  <%
        
        String url ="jdbc:mysql://localhost:8889/class";
        String usr ="root";
        String pass= "root";
        String query = "select * from posts";
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection(url,usr,pass);
             Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);  
            while(rs.next()){
                
            %>
  <a class="question" href="thread.jsp?id=<%=rs.getInt("post_id")%>">
            <div class="threads">
                <h2 class="thread"><%=rs.getString("post_title")%></h2>
                <p class="by"><b>By </b><%=rs.getString("user_name")%><b>Posted on</b> <%=rs.getString("post_ts")%></p>
                <p class="answers"> <b><%= rs.getInt("answers")%> Answers</b> </p>
                <div class="votes">
                <button type="button" class="btn btn-outline-success btn-sm">12 Upvote</button> <button type="button" class="btn btn-outline-danger btn-sm">2 Downvote</button>
            </div>
           </div>
         </a>
  <% } }  catch(Exception e)
        {
            session.setAttribute("msg",e);
            response.sendRedirect("error.jsp");
        }
  %> 
  <div class="pages">
    <nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center">
        <li class="page-item disabled">
          <a class="page-link" href="#" tabindex="-1">Previous</a>
        <li class="page-item active"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
          <a class="page-link" href="#">Next</a>
        </li>
      </ul>
    </nav>
  </div>
</div>

<%@ include file="inc/footer.jsp" %>
