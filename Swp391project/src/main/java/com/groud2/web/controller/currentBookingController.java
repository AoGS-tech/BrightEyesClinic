/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.bookingDAO;
import com.groud2.web.model.booking;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author asus
 */
public class currentBookingController extends HttpServlet {

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
            out.println("<title>Servlet currentBookingController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet currentBookingController at " + request.getContextPath() + "</h1>");
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
         bookingDAO b = new bookingDAO();
  
        try {
            ArrayList<booking> list = b.getCurrentBooking();
            request.setAttribute("listCurrent", list);
        } catch (SQLException ex) {
            Logger.getLogger(currentBookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        request.getRequestDispatcher("currentBooking.jsp").forward(request, response);
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
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        bookingDAO b = new bookingDAO();

        try {

            if (b.checkExist(email, phone)) {
                System.out.println("Email ton tai");
                if (email != null && !email.isEmpty() && phone != null && !phone.isEmpty()) {
                    ArrayList<booking> list = b.getAllCurrentByBoth(email, phone);
                    System.out.println("get booking by both");
                    request.setAttribute("list", list);
                }
            } else {
                
                request.setAttribute("check", "Your information was wrong. Please check again");
            }

            request.getRequestDispatcher("searchBooking.jsp").forward(request, response);

        } catch (SQLException ex) {
            System.out.println("hellloooo");
            Logger.getLogger(searchBookingController.class.getName()).log(Level.SEVERE, null, ex);
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

}