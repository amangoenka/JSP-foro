<%-- 
    Document   : bytopic.jsp
    Created on : 7 Oct, 2018, 11:36:11 PM
    Author     : niteshwaghmare
--%>
<%@page import="java.sql.*" %>
<%
    String topic =  request.getParameter("topic");
%>
<%! String title="Bytopic"; %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setHeader("Expires", "0"); // Proxies.
    if(session.getAttribute("user")== null){
            response.sendRedirect("index.jsp");
   }

%>

<%@ include file="inc/header.jsp" %>
<div class="container" style="margin-top: 50px;" id="body">
    <h2 class="" style="font-weight: bold"><%= topic%></h2>
   <hr>
  <%
        
        String url ="jdbc:mysql://localhost:8889/class";
        String usr ="root";
        String pass= "root";
        String query = "select * from posts where catagory_name='"+topic+"'";
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
</div>
<%@ include file="inc/footer.jsp" %>
