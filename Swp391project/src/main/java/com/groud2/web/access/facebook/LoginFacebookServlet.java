/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.access.facebook;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.user;
import com.restfb.types.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhha
 */
@WebServlet("/loginwithfacebook")
public class LoginFacebookServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginFacebookServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            String accessToken = RestFB.getToken(code);
            User user = (User) RestFB.getUserInfo(accessToken);
            user.getEmail();
            user.getGender();
            user.getName();
            userDAO u = new userDAO();
            user loginOK;
            try {
                loginOK = u.checklogin(user.getId());
                if (loginOK != null) {
                    session.setAttribute("id", user.getId());
                    session.setAttribute("name", user.getName());
                    response.sendRedirect("home");
                } else {

                    try {
                        u.createData(user.getName(), user.getId(), user.getEmail());
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginFacebookServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    session.setAttribute("id", user.getId());
                    session.setAttribute("name", user.getName());
                    response.sendRedirect("home");
                }

//            try {
//                u.createData(user.getName(), user.getId(), user.getEmail());
//            } catch (SQLException ex) {
//                Logger.getLogger(LoginFacebookServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (u.checkAccount(user.getId())) {
//                session.setAttribute("id", user.getId());
//                session.setAttribute("name", user.getName());
//                response.sendRedirect("home");
//            } else {
//                try {
//                    u.createData(user.getName(), user.getId(), user.getEmail());
//                } catch (SQLException ex) {
//                    Logger.getLogger(LoginFacebookServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                session.setAttribute("id", user.getId());
//                session.setAttribute("name", user.getName());
//                response.sendRedirect("home");
//            }
            } catch (SQLException ex) {
                Logger.getLogger(LoginFacebookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
