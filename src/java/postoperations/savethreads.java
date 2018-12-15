/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postoperations;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author niteshwaghmare
 */
@WebServlet(name = "savethreads", urlPatterns = {"/savethreads"})
public class savethreads extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              HttpSession session = request.getSession();
              String post_heading = request.getParameter("heading");
              String post_desc = request.getParameter("description");
              String topic = request.getParameter("topic");
              String username = session.getAttribute("user").toString();
              if(post_heading == null || post_desc == null || topic == null || username == null){
                  session.setAttribute("msg","Please enter valid data");
                  response.sendRedirect("error.jsp");
              }else{
                String url ="jdbc:mysql://localhost:8889/class";
                String usr ="root";
                String pass= "root";
                String query = "insert into posts(user_name,post_title,post_desc,catagory_name) values ('"+username+"','"+post_heading+"','"+post_desc+"','"+topic+"')";
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url,usr,pass);
                    Statement st = con.createStatement();
                    int result = st.executeUpdate(query);
                    if(result == 1){
                        response.sendRedirect("mythreads.jsp");
                    } else{
                       session.setAttribute("msg","Something went wrong");
                       response.sendRedirect("error.jsp");
                    }
                } catch(Exception e)
                {
                  session.setAttribute("msg",e);
                  response.sendRedirect("error.jsp");
                }
              }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
