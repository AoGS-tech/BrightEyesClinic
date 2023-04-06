/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.EmailDAO;
import com.groud2.web.DAO.userDAO;

import com.groud2.web.model.user;
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
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class updateController extends HttpServlet {

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
            out.println("<title>Servlet updateController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateController at " + request.getContextPath() + "</h1>");
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
        userDAO p = new userDAO();
        user check;
        HttpSession session = (HttpSession) request.getSession();
        String account = (String) session.getAttribute("id");
        String password = (String) session.getAttribute("pass");
        String newPass = request.getParameter("newPass");

        try {
            password = encyptPass(password);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("encode password error: " + ex.getMessage());
        }

        try {
            check = p.checkPass(account, password);
            if (check != null) {
                System.out.println("Account update: " + account);
                session.setAttribute("id", account);
                p.updatePass(account, newPass);

            } else {
                response.sendRedirect("loginuser");

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
        userDAO p = new userDAO();

        HttpSession session = (HttpSession) request.getSession();
        String account = (String) session.getAttribute("id");

        String newName = request.getParameter("newName");
        String newGender = request.getParameter("newGender");
        String newPhone = request.getParameter("newPhone");
        String newAddress = request.getParameter("newAddress");
        String newEmail = request.getParameter("newEmail");

        String inputBirthDate = request.getParameter("newBod");
        LocalDate newBod = LocalDate.parse(inputBirthDate);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String newBodString = dtf.format(newBod);
         boolean isNameValid = isValidName(newName);
        boolean isPhoneValid = isValidPhoneNumber(newPhone);
        boolean isEmailValid = isValidEmail(newEmail);
        boolean isDateValid = isAdult(newBod);
        if (!isValidName(newName)) {
            System.out.println("Invalid name");
            request.setAttribute("checkName", "Your name is invalid");
        }

        if (!isValidPhoneNumber(newPhone)) {
            System.out.println("Invalid phone");
            request.setAttribute("checkPhone", "Your phone is invalid (0xxxxxxxxx)");
        }

        if (!isValidEmail(newEmail)) {
            System.out.println("Invalid email");
            request.setAttribute("checkEmail", "Your email is invalid (xxx@gmail.com)");
        }
        if (!isAdult(newBod)) {
            System.out.println("Invalid date");
            request.setAttribute("checkDate", "Must be older than 18 years old");
        }
        if (isNameValid && isPhoneValid && isEmailValid && isDateValid) {
            System.out.println("chay update profile");
            p.updateProfile(account, newName, newGender, newPhone, newAddress, newEmail, newBodString);
            response.sendRedirect("profile");
        } else {
            // Nếu có ít nhất một giá trị không hợp lệ, hiển thị lại trang booking với thông báo lỗi
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        }
      

    }

    String encyptPass(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toLowerCase();
        return myHash;
    }

    public static boolean isValidName(String name) {
        // Kiểm tra tên không được để trống
        if (name == null || name.trim().length() == 0) {
            return false;
        }

        // Kiểm tra tên không chứa các ký tự đặc biệt hoặc số
        if (!name.matches("[a-zA-Z\\p{L}]+")) {
            return false;
        }

        // Kiểm tra tên không quá ngắn hoặc quá dài
        if (name.length() < 2 || name.length() > 50) {
            return false;
        }

        // Tên hợp lệ
        return true;
    }

    public static boolean isAdult(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        LocalDate adultDate = currentDate.minusYears(18);

        return birthDate.isBefore(adultDate);
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

}
