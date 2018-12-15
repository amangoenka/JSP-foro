/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userServlet;

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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            
                // session initalization
          HttpSession session = request.getSession();
          String email = request.getParameter("email");
          String password = PasswordEncryption.md5(request.getParameter("password"));
          if (email == null || password == null) {
            session.setAttribute("msg","Please enter valid data");
            response.sendRedirect("login.jsp");
          } else{
            String query = "select * from users where email='"+email+"'";
            String url ="jdbc:mysql://localhost:8889/class";
            String usr ="root";
            String pass= "root";
            try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection(url,usr,pass);
              Statement st = con.createStatement();
              ResultSet rs= st.executeQuery(query);
              // when user don't have account
              if (rs.equals("null")) {
                // session.setAttribute("msg","your email address doesn't match in our database");
                // response.sendRedirect("fail.jsp");
                System.out.println("Return nothing");
              } else {
                rs.next();
                // Password verifypass
                if(password.equals(rs.getString("password"))){
                  // All ok
                  session.setAttribute("user",rs.getString("name"));
                  
                  if(rs.getInt("Active") == 0)
                  {
                    session.setAttribute("active","Please active your account");
                  }
                  response.sendRedirect("home.jsp");

                }else {
                  // Wrong password
                  session.setAttribute("msg","Oops! your enterd wrong password!");
                  response.sendRedirect("login.jsp");
                }
              }
            } catch(SQLException s1){
              session.setAttribute("msg","your email address doesn't match in our database");
              response.sendRedirect("login.jsp");
            } catch(Exception e){
              session.setAttribute("msg","Something went wrong");
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
