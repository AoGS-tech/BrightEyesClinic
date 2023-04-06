/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Ao
 */
public class AdminEditUser extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String position = req.getParameter("setPosition");
        
        String exit = req.getParameter("exit");
        String save = req.getParameter("save");
        
        if(exit != null || save != null){
            returnToMain(position, req, resp);
        }
        
        req.getRequestDispatcher("AdminView/admin-screen/AdminEditUser.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("AdminView/admin-screen/AdminEditUser.jsp").forward(req, resp);
    }
    
    public void returnToMain(String pos, HttpServletRequest req, HttpServletResponse resp) throws IOException{
        if(pos.equals("2")) resp.sendRedirect("manageStaff");
        else if(pos.equals("3")) resp.sendRedirect("manageCustomer");
    }
}
