package com.groud2.web.controller;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import jakarta.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/java/loginController.java
/**
 *
 * @author anhha
 */
public class loginController extends HttpServlet {

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

            out.println("<title>Servlet loginController</title>");

            out.println("<title>Servlet loginController</title>");

//=======
            out.println("<title>Servlet loginController</title>");
//>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/java/loginController.java

            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String captchaText = request.getParameter("captchaInput");
        String captchaAgain = request.getParameter("loadCaptchaAgain");
        String rememberpass = request.getParameter("rememberpass");
        //tao 3 cookie 
        //username,pass,status checkbox
        Cookie acc = new Cookie("acc", account);
        Cookie pass = new Cookie("pass", password);
        Cookie status = new Cookie("status", rememberpass);
        if (status.getValue() != null) {
            acc.setMaxAge(60 * 60 * 24 * 7);
            pass.setMaxAge(60 * 60 * 24 * 7);
            status.setMaxAge(60 * 60 * 24 * 7);
        } else {
            acc.setMaxAge(0);
            pass.setMaxAge(0);
            status.setMaxAge(0);
        }
        response.addCookie(acc);
        response.addCookie(pass);
        response.addCookie(status);
        try {
            password = encyptPass(password);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("encode password error: " + ex.getMessage());
        }

        System.out.println("password = " + password);

        //reload captcha code
//        try {
//            if (!captchaAgain.isEmpty()) {
//            request.setAttribute("account", account);
//            request.setAttribute("password", password);
//            request.setAttribute("captchaErr", "");
//            request.getRequestDispatcher("Login.jsp").forward(request, response);
//        }
//        } catch (Exception e) {
//            System.out.println("Error here 111: " +e.getMessage());
//        }
        //Xu ly           
        userDAO u = new userDAO();
        user d = new user();
        user loginOK;

        try {
            loginOK = u.checklogin(account, password);

            if (loginOK != null) { // Check login credentials first
                if (validateCaptcha(captchaText, request, response)) { // If captcha is valid, set session attributes and redirect
                    HttpSession session = request.getSession();
                    String fullname = u.getUserName(account);
                    String phone = u.getUserPhone(account);
                    String email = u.getUserEmail(account);
                    session.setAttribute("phoneLg", phone);
                    session.setAttribute("emailLg", email);
                    System.out.println("check emai, phone sesssion login: " + email + phone);
                    session.setAttribute("id", account);
                    session.setAttribute("fullname", fullname);
                    String role = u.getUserRole(account);

                    session.setAttribute("id", account);
                    session.setAttribute("fullname", fullname);

                    if (role.equals("admin")) {
                        response.sendRedirect("adminDashboard");
                    } else if (role.equalsIgnoreCase("doctor")) {
                        response.sendRedirect("listWattingPatient");
                    } else {
                        response.sendRedirect("home");
                    }
                } else { // If captcha is invalid, display error message
                    request.setAttribute("account", account);
                    request.setAttribute("password", password);
                    request.setAttribute("captchaErr", "Captcha not match, enter again!");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                    response.sendRedirect("loginuser");
                }
            } else { // If login credentials are invalid, display error message
                request.setAttribute("account", account);
                request.setAttribute("password", password);
                request.setAttribute("captchaErr", "Invalid login credentials, please try again!");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                response.sendRedirect("loginuser");
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    String encyptPass(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toLowerCase();
        return myHash;
    }

    public boolean validateCaptcha(String captchaText, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get captcha text from session
        String captchaSession = (String) request.getSession().getAttribute("captcha");
        return captchaText.equals(captchaSession);
    }
}
