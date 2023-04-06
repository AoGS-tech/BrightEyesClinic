/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.EmailDAO;
import com.groud2.web.DAO.bookingDAO;
import com.groud2.web.DAO.userDAO;
import jakarta.mail.MessagingException;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhha
 */
public class bookingController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet bookingController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet bookingController at " + request.getContextPath() + "</h1>");
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

        String sbtime;
        HttpSession session = request.getSession();
        String fullname = (String) session.getAttribute("fullname");
        String phoneLg = (String) session.getAttribute("phoneLg");
        String emailLg = (String) session.getAttribute("emailLg");

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String date = request.getParameter("dateInput");
        String time = request.getParameter("time");
        String medical = request.getParameter("description");
        String payment = request.getParameter("payment");
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("check name before send to success: " + name);
        request.setAttribute("name", name);
        request.setAttribute("phone", phone);
        request.setAttribute("email", email);
        request.setAttribute("date", date);
        request.setAttribute("time", time);
        request.setAttribute("medical", medical);
        request.setAttribute("payment", payment);
        boolean isNameValid = isValidName(name);
        boolean isPhoneValid = isValidPhoneNumber(phone);
        boolean isEmailValid = isValidEmail(email);
        boolean isDateValid = isValidDate(date);

        request.setAttribute("fullname", fullname);
        request.setAttribute("phoneLg", phoneLg);
        request.setAttribute("emailLg", emailLg);
        System.out.println("check Lg: " + emailLg + phoneLg);
        if (!isValidName(name)) {

            request.setAttribute("checkName", "Your name is invalid");
        }
        if (time.equals("null")) {
            
            request.setAttribute("checkTime", "Please choose time");
        }
        if (!isValidPhoneNumber(phone)) {

            request.setAttribute("checkPhone", "Your phone is invalid (0xxxxxxxxx)");
        }

        if (!isValidEmail(email)) {

            request.setAttribute("checkEmail", "Your email is invalid (xxx@gmail.com)");
        }
        if (!isValidDate(date)) {

            request.setAttribute("checkDate", "Your Date is invalid");
        }
// All input values are valid, proceed with inserting into database
        // Định dạng ngày giờ theo định dạng "yyyy-MM-dd HH:mm:ss"
        String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        sbtime = formattedDateTime;
        userDAO u = new userDAO();
        if (isNameValid && isPhoneValid && isEmailValid && isDateValid) {
            try {
                EmailDAO e = new EmailDAO();
                e.MailConfirmAppointment(email, name, date, time);

                request.setAttribute("success", "You have successfully booked. Please check your email for details about the consulting");

            } catch (MessagingException ex) {
                Logger.getLogger(bookingController.class.getName()).log(Level.SEVERE, null, ex);
            }
            b.insert(name, phone, email, date, time, medical, payment, sbtime);
            System.out.println("date = " + date);
            request.getRequestDispatcher("successBooking").forward(request, response);

        } else {
            // Nếu có ít nhất một giá trị không hợp lệ, hiển thị lại trang booking với thông báo lỗi
            request.getRequestDispatcher("booking.jsp").forward(request, response);
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

        //Get request from client
        String position = request.getParameter("position");
        String setPos = request.getParameter("setPosition");

        if (position == null) {
            position = setPos;
        }

        System.out.println("Position = " + position);
        if (!position.equals("7")) {
            changePosition(position, request, response);
        } else {
            response.sendRedirect("searchBooking");
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

    public static boolean isValidName(String name) {
        // Kiểm tra tên không được để trống và không chứa khoảng trắng đầu hoặc cuối chuỗi
        if (name == null || name.trim().length() == 0 || name.startsWith(" ") || name.endsWith(" ")) {
            return false;
        }

        // Kiểm tra tên không chứa các ký tự đặc biệt hoặc số
        if (!name.matches("[\\p{L} ]+")) {
            return false;
        }

        // Kiểm tra tên không quá ngắn hoặc quá dài
        if (name.length() < 2 || name.length() > 50) {
            return false;
        }

        // Tên hợp lệ
        return true;
    }

    public static boolean isValidDate(String inputDate) {
        boolean isValid = true;
        LocalDate currentDate = LocalDate.now();
        LocalDate selectedDate = LocalDate.parse(inputDate);

        if (selectedDate.isBefore(currentDate)) {
            // Ngày đã chọn ở quá khứ
            isValid = false;
        } else if (selectedDate.isAfter(currentDate.plusDays(14))) {
            // Ngày đã chọn quá 2 tuần kể từ ngày hiện tại
            isValid = false;
        }

        return isValid;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Xóa khoảng trắng và các ký tự không phải số
        String cleanedPhoneNumber = phoneNumber.replaceAll("[^0-9]", "");

        // Kiểm tra độ dài của số điện thoại
        if (cleanedPhoneNumber.startsWith("+84") && cleanedPhoneNumber.length() != 12) {
            return false;
        } else if (cleanedPhoneNumber.startsWith("0") && cleanedPhoneNumber.length() != 10 && cleanedPhoneNumber.length() != 11) {
            return false;
        }

        // Kiểm tra đầu số của số điện thoại
        String prefix = cleanedPhoneNumber.substring(0, 2);
        if (!prefix.equals("09") && !prefix.equals("03") && !prefix.equals("07") && !prefix.equals("08") && !prefix.equals("84")) {
            return false;
        }

        // Kiểm tra xem số điện thoại chỉ chứa các ký tự số
        if (!cleanedPhoneNumber.matches("[0-9]+")) {
            return false;
        }

        // Số điện thoại hợp lệ
        return true;
    }

    public static boolean isValidEmail(String email) {
        // Kiểm tra email không được để trống
        if (email == null || email.trim().length() == 0) {
            return false;
        }

        // Kiểm tra email chứa ký tự @ và .
        if (!email.matches("[\\w\\.-]+@[\\w\\.-]+")) {
            return false;
        }

        // Kiểm tra ký tự @ và . không xuất hiện ở đầu hoặc cuối địa chỉ email
        if (email.startsWith("@") || email.endsWith("@") || email.startsWith(".") || email.endsWith(".")) {
            return false;
        }

        // Kiểm tra ký tự "." không xuất hiện liên tiếp với ký tự "@"
        if (email.indexOf("@.") != -1 || email.indexOf(".@") != -1) {
            return false;
        }

        // Kiểm tra tên miền phải có ít nhất một dấu chấm và phải có ít nhất hai ký tự
        String[] parts = email.split("\\.");
        String lastPart = parts[parts.length - 1];
        if (parts.length < 2 || lastPart.length() < 2) {
            return false;
        }

        // Email hợp lệ
        return true;
    }

    private void changePosition(String pos, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        switch (pos) {
            case "1":
                resp.sendRedirect("adminDashboard");
                break;
            case "2":
                resp.sendRedirect("manageStaff");
                break;
            case "3":
                resp.sendRedirect("manageCustomer");
                break;
            case "4":
                resp.sendRedirect("manageRoom");
                break;
            case "5":
                resp.sendRedirect("manageGlasses");
                break;
            case "6":
                resp.sendRedirect("feedback");
                break;
            case "7":
                resp.sendRedirect("searchBooking");
                break;
            case "8":
                resp.sendRedirect("adminDashboard");
                break;
            default:
                throw new AssertionError();
        }

    }

}