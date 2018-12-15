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



@WebServlet(name = "savecomments", urlPatterns = {"/savecomments"})
public class savecomments extends HttpServlet {

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
        String comment = request.getParameter("comment");
        String user_name = request.getParameter("user_name");
        int id = Integer.parseInt(request.getParameter("id"));
        String query = "insert into replies(reply_desc,user_name,post_id)values ('"+comment+"','"+user_name+"',"+id+")";
        
        if(comment.equals("null") || user_name.equals("null") || id == 0)
        {
            
        } else{
          String url ="jdbc:mysql://localhost:8889/class";
          String usr ="root";
          String pass= "root";
          System.out.print(query);
          try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection(url,usr,pass);
              Statement st = con.createStatement();
              int result = st.executeUpdate(query);
              if(result == 1){
                  String link = "thread.jsp?id="+id;
                  response.sendRedirect(link);
              } else{
                  System.out.print("data problem");
              }
          }catch(Exception e)
          {
              System.out.print(e);
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
