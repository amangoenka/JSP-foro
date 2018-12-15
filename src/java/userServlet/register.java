package userServlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javatasks.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author niteshwaghmare
 */
@WebServlet(urlPatterns = {"/register"})
public class register extends HttpServlet {

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
          
        String name = request.getParameter("name");
        String password = PasswordEncryption.md5(request.getParameter("password"));
        String hash = HashGeneration.hashing(25);
        String email = request.getParameter("email");
        if (name == null || password == null || hash == null || email == null)  {
            session.setAttribute("msg","Please enter valid data");
            response.sendRedirect("index.jsp");
        } else {
          String query = "insert into users (name,email,password,hash) values('"+name+"','"+email+"','"+password+"','"+hash+"')";
          String url ="jdbc:mysql://localhost:8889/class";
          String usr ="root";
          String pass= "root";
          try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection(url,usr,pass);
              Statement st = con.createStatement();

              // Mailing method

              int result = st.executeUpdate(query);
              if(result == 1){
                  session.setAttribute("user",name);
                  session.setAttribute("active", "Please verify your email address");
                  response.sendRedirect("home.jsp");
              } else{
                  session.setAttribute("msg","Something went wrong");
                  response.sendRedirect("error.jsp");
              }
          }catch(SQLException s1){
            session.setAttribute("msg","You already registered");
            response.sendRedirect("index.jsp");
          }catch(Exception e)
          {
              // System.out.println(e);
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
