/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.patientDAO;
import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class recordController extends HttpServlet {

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
            out.println("<title>Servlet recordController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet recordController at " + request.getContextPath() + "</h1>");
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
        userDAO u = new userDAO();
        String check = request.getParameter("check");
        String message = null;
        if (check != null) {
            if (check.equals("invalidBirthday")) {
                message = "Your birth date is invalid";
            }
        }

        try {
            ArrayList<user> listrole = u.getUsersByRole();
            request.setAttribute("listrole", listrole);
            System.out.println("heo");
            if (message != null) {
                request.setAttribute("check", message);
            }
            request.getRequestDispatcher("recordOffline.jsp").forward(request, response);
        } catch (SQLException ex) {
            System.out.println("hellloooo");
            Logger.getLogger(recordController.class.getName()).log(Level.SEVERE, null, ex);
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
//           userDAO ud = new userDAO();
//        String customerAcc = patientName.replaceAll(" ", "").toLowerCase();
//        String password = "e10adc3949ba59abbe56e057f20f883e";
//        ud.createData(doctorName, customerAcc, password, phone, address, email, gender, bod, "customer");
        patientDAO pa = new patientDAO();
        userDAO u = new userDAO();
        HttpSession session = request.getSession();
        String IdCard = request.getParameter("idcard");
        String patientName = request.getParameter("patientName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        System.out.println(address);
        String bod = request.getParameter("bod");

        String gender = request.getParameter("gender");
        String account = email;
        String password = "202cb962ac59075b964b07152d234b70";
        String role = "customer";

        System.out.println("Gender: " + gender);
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // Định dạng chuỗi
        String medicalDate = now.format(formatter);
        String symptom = request.getParameter("symptom");
        String doctorName = request.getParameter("doctor");
        LocalDate validate = now.minusYears(2);
        LocalDate bodlocal = LocalDate.parse(bod);
        System.out.println(medicalDate);
        String time = "";
        if (bodlocal.isAfter(validate)) {
            request.setAttribute("check", "Your birth date is invalid");
            response.sendRedirect("record?check=invalidBirthday");
        } else {

            try {

                u.createData(patientName, account, password, phone, address, email, gender, bod, role);

            } catch (Exception e) {
                System.out.println("fail");
            }

            try {
                int userId = u.getIdbyAccount(account);
                System.out.println("ha" + account + userId);
                pa.insertPatient(IdCard, userId, medicalDate, symptom, doctorName);
                String id1=String.valueOf(userId);
                session.setAttribute("id1",id1 );
                response.sendRedirect("Bill");
                //request.getRequestDispatcher("Bill").forward(request, response);
            } catch (Exception e) {
            }
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
