/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
<<<<<<< Updated upstream
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.groud2.web.controller;


import com.groud2.web.DAO.userDAO;

import com.groud2.web.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class profileController extends HttpServlet{

  

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
            out.println("<title>Servlet profile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet profile at " + request.getContextPath() + "</h1>");
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
        userDAO g =new userDAO();
      
        
        String account = (String) session.getAttribute("id");
        user p = new user();
        try {
            p = g.getUser(account);
        } catch (SQLException ex) {
            Logger.getLogger(profileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String name, pass, phonenumber, address, email, gender, bod, image;
        try {
            ArrayList<user> list = g.getAllByAcc(account);
               
                phonenumber = p.getPhonenumber();
                name=p.getFullname();
                pass=p.getPassword();
                email=p.getEmail();
                address=p.getAddress();
                bod=p.getBod();
                gender = p.getGender();
                image = p.getUserimages(); 
                
                session.setAttribute("account", account);
                session.setAttribute("fullname", name);
                session.setAttribute("phonenumber", phonenumber);
                session.setAttribute("email", email);
                session.setAttribute("address", address);
                session.setAttribute("bod", bod);
                session.setAttribute("pass", pass);
                session.setAttribute("image", image); 
                session.setAttribute("gender", gender);
                System.out.println("test name profile: "+name);
                
                System.out.println("test: "+account);
            request.setAttribute("list", list);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            System.out.println("hellloooo");
            Logger.getLogger(glassesController.class.getName()).log(Level.SEVERE, null, ex);
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
         userDAO p = new userDAO();
        
        HttpSession session = (HttpSession) request.getSession();
        String account = (String) session.getAttribute("id");
       
                
        String newName = request.getParameter("newName");
        String newGender = request.getParameter("newGender");
        String newPhone = request.getParameter("newPhone");
        String newAddress = request.getParameter("newAddress");
        String newEmail = request.getParameter("newEmail");
        String newBod = request.getParameter("newBod");     
        p.updateProfile(account, newName, newGender, newPhone, newAddress, newEmail, newBod);
       
        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}