/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller.DoctorController;

import com.groud2.web.DAO.patientDAO;
import com.groud2.web.model.patient;
import com.groud2.web.model.user;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class listCompletePatient extends HttpServlet {

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
            out.println("<title>Servlet listCompletePatient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet listCompletePatient at " + request.getContextPath() + "</h1>");
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
        String username = (String) session.getAttribute("id");
        request.setAttribute("username", username);
        String fullname1 = (String) session.getAttribute("fullname");
        request.setAttribute("username", username);
        //Lay date now
        LocalDate now = LocalDate.now();
        request.setAttribute("now", now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // Định dạng chuỗi
        String datenow = now.format(formatter);

        //xu ly output patient with process watting
        String process = "1";
        patientDAO pa = new patientDAO();
        System.out.print("Lay du lieu booking: ");
        ArrayList<patient> listCompletePatient;
   
        try {
            listCompletePatient = pa.getPatientByDay(fullname1, process,datenow);
            
                System.out.println("Thanh cong roi day");
//            for (patient item : listCompletePatient) {
//               System.out.println("day1" + item.getIdcard());
//               System.out.println("day1" + item.getStatus());
//               System.out.println("day1" + item.getFullname());
//            
//            }

                request.setAttribute("listCompletePatient", listCompletePatient);
               
           
            request.getRequestDispatcher("DoctorView/doctor-screen/ListCompletePatient.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(listCompletePatient.class.getName()).log(Level.SEVERE, null, ex);
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
