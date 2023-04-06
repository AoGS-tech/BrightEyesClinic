/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/* Ao master file */

package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ao
 */
public class AdminAddNewUserController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String account = req.getParameter("account");
        //String id = req.getParameter("id");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phonenumber");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String dob = req.getParameter("dob");
        String role = req.getParameter("role");
        
        
        String password = "";
        try {
            password = encyptPass("123456");
        } catch (NoSuchAlgorithmException ex) { 
            Logger.getLogger(AdminAddNewUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        userDAO u = new userDAO();
        try {
            u.createData(name, account, password, phone, address, email, gender, dob, role);
        } catch (SQLException ex) {
            Logger.getLogger(AdminAddNewUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession session = req.getSession();
        String backPage = (String) session.getAttribute("backPage");
        if(backPage != null) session.removeAttribute(backPage);
        resp.sendRedirect(backPage);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = String.valueOf(GetLastUserID());
        String backPage = req.getParameter("backPage");
        String userRole = req.getParameter("userRole");
        System.out.println("back page = " + backPage);
        
        HttpSession session = req.getSession();
        session.setAttribute("backPage", backPage);
        req.setAttribute("userRole", userRole);
        req.setAttribute("id", id);
        req.getRequestDispatcher("AdminView/admin-screen/AdminAddNewUser.jsp").forward(req, resp);
    }
    
    public int GetLastUserID(){
        userDAO u = new userDAO();
        ArrayList<user> list = u.getListUser("", "");
        int id = 0;
        for (user object : list) {
            int userId = Integer.parseInt(object.getUserId());
            if(userId > id) id = userId;
        }
        id++;
        return id;
    }
    
    String encyptPass(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toLowerCase();
        return myHash;
    }
    public static boolean isValidFullName(String fullName) {
        // Regular expression pattern for a full name with at least two words
        Pattern pattern = Pattern.compile("^[a-zA-Z]+ [a-zA-Z]+(?: [a-zA-Z]+)*$");
        Matcher matcher = pattern.matcher(fullName);
        return matcher.matches();
    }
    public static boolean isValidEmail(String email) {
        // Regular expression pattern for a valid email address
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
