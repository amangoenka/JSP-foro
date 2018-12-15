<%--
    Document   : remove.jsp
    Created on : 7 Oct, 2018, 12:32:39 PM
    Author     : niteshwaghmare
--%>
<%@page import="java.sql.*" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));

    if(session.getAttribute("user")== null){
            response.sendRedirect("index.jsp");
   }
    String url ="jdbc:mysql://localhost:8889/class";
    String usr ="root";
    String pass= "root";
    String query = "delete from posts where post_id="+id;
    String deletecomments = "delete from replies where post_id="+id;
    try{
        Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection(url,usr,pass);
              Statement st = con.createStatement();
              int rs = st.executeUpdate(query);
              int rs1 = st.executeUpdate(deletecomments);
              if(rs == 1)
              {
                response.sendRedirect("mythreads.jsp");
              } else{
                  response.sendRedirect("error.jsp");
              }
    } catch(Exception e)
    {
        session.setAttribute("msg",e);
        response.sendRedirect("error.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
