/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class changePass extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet changePass</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet changePass at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HttpSession session = request.getSession();
        userDAO g = new userDAO();
        
        user check;
        String account = (String) session.getAttribute("id");
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String checkNewPass = request.getParameter("checkNewPass");
        user p = new user();
        try {
            newPass = encyptPass(newPass);
            oldPass = encyptPass(oldPass);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("encode password error: " + ex.getMessage());
        }
       
            try {
                check = g.checkPass(account, oldPass);
                if(newPass.equals(oldPass)){
                    request.setAttribute("ms2", "New password same old password. Please check again.");
                    request.getRequestDispatcher("changePass.jsp").forward(request, response);
                }
                else if (check != null) {
                    System.out.println("Account, password correct: " + account + "," + oldPass);
                    g.updatePass(newPass, account);
                    response.sendRedirect("home");

                } else {
                    System.out.println("Wrong password");
                    request.setAttribute("ms2", "Your old password was wrong. Please check again");
                    request.getRequestDispatcher("changePass.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
       

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
        HttpSession session = request.getSession();
        userDAO g = new userDAO();
        userDAO u = new userDAO();

        String account = (String) session.getAttribute("id");
        user p = new user();
        try {
            p = u.getUser(account);
        } catch (SQLException ex) {
            Logger.getLogger(profileController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    String encyptPass(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toLowerCase();
        return myHash;
    }
}
