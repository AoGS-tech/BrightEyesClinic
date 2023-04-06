/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller.DoctorController;

import com.groud2.web.DAO.patientDAO;
import com.groud2.web.model.patient;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
public class ReportError extends HttpServlet {

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
            out.println("<title>Servlet ReportError</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReportError at " + request.getContextPath() + "</h1>");
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
        String Idcard = request.getParameter("Idcard");
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // Định dạng chuỗi
        String medicalDate = now.format(formatter);
        patientDAO pa = new patientDAO();
        patient p = new patient();
        String userId, time, symptom, doctorName;
        String processOK = "0";
        ArrayList<patient> Infor;
        System.out.print("Lay du lieu booking: ");
        //update lai database sau khi kham xong      
        try {
            Infor = pa.getInfor(Idcard, medicalDate);
            for (patient item : Infor) {
                System.out.println("day" + item.getIdcard());
                System.out.println("day" + item.getUserid());
                System.out.println("day" + item.getTimeOrder());
                System.out.println("day" + item.getDoctorName());
                System.out.println("day" + item.getSymptom());
                System.out.println("day" + item.getIdcard());
                
                userId = item.getUserid();
                time = item.getTimeOrder();
                symptom = item.getSymptom();
                doctorName=item.getDoctorName();
                session.setAttribute("userId", userId);
                session.setAttribute("time", time);
                session.setAttribute("symptom", symptom);
                session.setAttribute("doctorName", doctorName);

            }
            userId=(String) session.getAttribute("userId");
            time=(String) session.getAttribute("time");
            symptom=(String) session.getAttribute("symptom");
            doctorName=(String) session.getAttribute("doctorName");
            String IdCard=Idcard;
            pa.Delete(Idcard, medicalDate);
            pa.insertPatientBy(IdCard, userId, time, medicalDate, symptom, doctorName);
            

            response.sendRedirect("listWattingPatient");
        } catch (SQLException ex) {
            Logger.getLogger(medicalRecord.class.getName()).log(Level.SEVERE, null, ex);
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
