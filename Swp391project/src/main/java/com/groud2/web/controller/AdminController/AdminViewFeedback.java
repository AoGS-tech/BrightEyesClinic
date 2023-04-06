/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.feedbackDAO;
import com.groud2.web.model.feedback;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ao
 */
public class AdminViewFeedback extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("id");
        req.setAttribute("username", username);
        feedbackDAO f = new feedbackDAO();

        try {
            ArrayList<feedback> list = f.getFeedback();
            req.setAttribute("listFb", list);
            System.out.println("helu");
            req.getRequestDispatcher("AdminView/admin-screen/ViewFeedBack.jsp").forward(req, resp);
        } catch (SQLException ex) {
            System.out.println("hellloooo");
//            Logger.getLogger(glassesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.getRequestDispatcher("AdminView/admin-screen/ViewFeedBack.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get request from client
        String position = req.getParameter("position");
        String setPos = req.getParameter("setPosition");
        if (position == null) {
            position = setPos;
        }
        //Handle request
        if (!position.equals("6")) {
            changePosition(position, req, resp);
        } else {
            feedbackDAO f = new feedbackDAO();

            try {
                ArrayList<feedback> list = f.getFeedback();
                req.setAttribute("listFb", list);
                System.out.println("helu");
                req.getRequestDispatcher("AdminView/admin-screen/ViewFeedBack.jsp").forward(req, resp);
            } catch (SQLException ex) {
                System.out.println("hellloooo");
//            Logger.getLogger(glassesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
                resp.sendRedirect("adminDashboard");
                break;
            case "8":
                resp.sendRedirect("adminDashboard");
                break;
            default:
                throw new AssertionError();
        }
    }
}
