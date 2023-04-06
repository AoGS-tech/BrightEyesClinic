/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ao
 */
public class AdminManagerStaffController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDAO u = new userDAO();
        ArrayList<user> listUser = u.getListUser("admin", "");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("id");
        req.setAttribute("username", username);
        req.setAttribute("listUser", listUser);
        req.getRequestDispatcher("AdminView/admin-screen/ManageStaff.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //Get request from client
            String position = req.getParameter("position");
            String setPos = req.getParameter("setPosition");
            if (position == null) {
                position = setPos;
            }
            System.out.println("My position: " + position);
            //Handle request
            if (position.equals("2")) {

                String search = req.getParameter("search");
                
                
                //search staff
                if(search != null){
                    searchStaff(search, req, resp);
                }
                
                
            } else {
                changePosition(position, req, resp);
            }
        } catch (Exception e) {
            System.out.println("Manager staff servlet error: " + e.getMessage());
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
                resp.sendRedirect("searchBooking");
                break;
            case "8":
                resp.sendRedirect("adminDashboard");
                break;
            default:
                throw new AssertionError();
        }
    }

    //search list staff
    public void searchStaff(String search, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDAO u = new userDAO();
        ArrayList<user> listUser = u.getListUser("admin", search);
        req.setAttribute("listUser", listUser);
        req.getRequestDispatcher("AdminView/admin-screen/ManageStaff.jsp").forward(req, resp);
    }
}
