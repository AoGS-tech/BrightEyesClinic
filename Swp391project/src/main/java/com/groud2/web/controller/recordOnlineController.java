/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.bookingDAO;
import com.groud2.web.DAO.patientDAO;
import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.booking;
import com.groud2.web.model.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class recordOnlineController extends HttpServlet {

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
            out.println("<title>Servlet recordOnlineController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet recordOnlineController at " + request.getContextPath() + "</h1>");
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
        patientDAO pa = new patientDAO();
        userDAO u = new userDAO();
         HttpSession session = request.getSession();
        String message = null;
        String IdCard = request.getParameter("idcard");
        String patientName = request.getParameter("patientName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String bod = request.getParameter("bod");
        String gender = request.getParameter("gender");
        String role = "customer";
        String account = email;
        String password = "202cb962ac59075b964b07152d234b70";

        String time = request.getParameter("time");
        System.out.println(time);
        System.out.println("Gender: " + gender);
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // Định dạng chuỗi
        String medicalDate = now.format(formatter);
        String symptom = request.getParameter("symptom");
        String doctorName = request.getParameter("doctor");
        LocalDate validate = now.minusYears(2);
        LocalDate bodlocal = LocalDate.parse(bod);
        
        String id1=String.valueOf(u.getIdbyPhone(phone));
        session.setAttribute("id1", id1);
        System.out.println("% gio ccom chua ngu"+id1);
        if (bodlocal.isAfter(validate)) {
            request.setAttribute("check", "Your birth date is invalid");
            message = "Your birth date is invalid";
            ArrayList<user> listrole = new ArrayList<>();
            try {
                listrole = u.getUsersByRole();
            } catch (SQLException ex) {
                Logger.getLogger(recordOnlineController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("idcard", IdCard);
            request.setAttribute("patientName", patientName);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.setAttribute("address", address);
            request.setAttribute("bod", bod);
            request.setAttribute("gender", gender);
            request.setAttribute("symptom", symptom);
            request.setAttribute("time", time);
            request.setAttribute("doctor", doctorName);
            request.setAttribute("listrole", listrole);
            System.out.println("heo");
            if (message != null) {
                request.setAttribute("check", message);
            }
            bookingDAO b = new bookingDAO();
           
            String id = (String) session.getAttribute("userIdBooking");
            
            System.out.println("id session = " + id);
            ArrayList<booking> listid = new ArrayList<>();
            try {
                listid = b.getAllById(id);
            } catch (SQLException ex) {
                Logger.getLogger(recordOnlineController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("listid", listid);
            System.out.println("list id size = " + listid.size());
             
            
            if(id != null){
                session.removeAttribute("userIdBooking");
            }
            request.getRequestDispatcher("recordOnline.jsp").forward(request, response);
//            response.sendRedirect("recordOnline?check=invalidBirthday");
        } else {

            System.out.println(medicalDate);
//        String processOK="1";
            try {
//            if (u.checkExistUser(email, phone)) {
//                 u.createData(patientName, account, password, phone, address, email, gender, bod, role);
//            } else {
//            }
                u.createData(patientName, account, password, phone, address, email, gender, bod, role);
                int userId = u.getIdbyPhone(phone);
                System.out.println(userId);
                pa.insertPatient2(IdCard, userId, time, medicalDate, symptom, doctorName, symptom);
//            pa.Successful2(IdCard, userId);

             
    
                response.sendRedirect("Bill");
                 

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("fail");
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
