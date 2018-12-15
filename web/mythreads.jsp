<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%

    if(session.getAttribute("user")== null){
            response.sendRedirect("index.jsp");
    }
     response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
     response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
     response.setHeader("Expires", "0"); // Proxies.
%>
<%! String title="My threads | foro"; %>
  <%@ include file="inc/header.jsp" %>
<div class="container" id="body">
    <% if(session.getAttribute("active") != null ){ %>
    <div class="alert alert-warning"  style="margin-top: 20px;" id="active" role="alert">
        <%= "Please verify your account verification link sent you email address" %>
    </div>
    <% } %>
  <button style="margin-top: 20px; margin-buttom: 20px;" type="button" data-toggle="modal" data-target="#exampleModalCenter" class="btn btn-primary" name="button">Create thread</button>
  <hr>
  <div class="threadlist">
    <%
        String user = session.getAttribute("user").toString();
        String query = "select * from posts where user_name='"+user+"'";
        String url ="jdbc:mysql://localhost:8889/class";
        String usr ="root";
        String pass= "root";
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(url,usr,pass);
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(query);
          if(rs.equals("null")){ %>
          <%=  "<p class=\"nothreads\" style=\"margin: 200px auto; text-align: center;\">No! threads Found</p>"  %>
    <% } while(rs.next()){   %>
      <div class="alert alert-secondary" id="threadlist" role="alert">
      <div class="row">
        <div class="col-md-9">
          <p class="threadheading"><b>
              <%= rs.getString("post_title") %> </b> </p>
              <span> <b>Posted</b> <%= rs.getString("post_ts") %>
              <b>Topic:</b> <%= rs.getString("catagory_name") %></span>
        </div>
        <div class="col-md-3">
            
            <a class="btn btn-success float-right" id="links" style="margin-right: 5px;" href="thread.jsp?id=<%=rs.getInt("post_id")%>">View</a>  <button type="button" id="links" style="margin-right: 5px;" onclick="firm(<%=rs.getInt("post_id")%>)" class="btn btn-danger float-right">Delete</button>
        </div>
      </div>
    </div>
    <% }
            } catch (Exception e){
                session.setAttribute("msg",e);
                response.sendRedirect("error.jsp");
            }
    %>
  </div>
  <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalCenterTitle"><b>Create Thread</b></h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <form class="" action="savethreads" method="post">
            <div class="form-group">
              <label for="exampleFormControlInput1">Question</label>
              <input type="text" required name="heading" class="form-control" id="exampleFormControlInput1" placeholder="">
            </div>
            <div class="form-group">
              <label for="exampleFormControlTextarea1">Descrption</label>
              <textarea class="form-control" required name="description" id="exampleFormControlTextarea1" rows="6"></textarea>
            </div>
            <div class="form-group">
              <label for="exampleFormControlSelect1">Topic select</label>
              <select required="required"class="form-control" name="topic"  id="exampleFormControlSelect1">
                <option option value="">Topic</option>
                <option option value='Techinical'>Technical</option>
                <option option value='Social'> Social</option>
                <option option value='Health'>Health</option>
                <option option value='Environment'>Environment</option>
                <option option value='Other'>Other</option>
              </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>

        </div>
      </div>
    </div>
  </div>
</div>

<%@ include file="inc/footer.jsp" %>
