/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.bookingDAO;
import com.groud2.web.model.booking;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ao
 */
public class AdminDasboardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         HttpSession session = req.getSession();
         bookingDAO bd = new bookingDAO();
         String username = (String)session.getAttribute("id");
         LocalDate todayLocalDate = LocalDate.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String today = formatter.format(todayLocalDate);
         ArrayList<booking> listBookingByDate = new ArrayList<>();
        try {
            listBookingByDate = bd.getListBookingByDate(today);
        } catch (SQLException ex) {
            Logger.getLogger(AdminDasboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<String> listTimeBooking = new ArrayList<>();
        for (booking b : listBookingByDate) {
            listTimeBooking.add(b.getTime());
        }
        
        HashSet<String> distinctTime = new HashSet<String>(listTimeBooking);
        listTimeBooking = new ArrayList<>(distinctTime);
        Collections.sort(listTimeBooking);
        ArrayList<Integer> countCustomer = new ArrayList<>();
        for (int i = 0; i < listTimeBooking.size(); i++) {
            int count = 0;
            for (int j = 0; j < listBookingByDate.size(); j++) {
                if(listTimeBooking.get(i).equals(listBookingByDate.get(j).getTime())) count++;
            }
            countCustomer.add(count);
        }
        System.out.println("total different time = " + listTimeBooking);
         System.out.println("list booking by date size = " + listBookingByDate.size());
         req.setAttribute("labelsCustomerBooking", listTimeBooking);
         req.setAttribute("dataCustomerBooking", countCustomer);
         req.setAttribute("date", today);
         req.setAttribute("totalRevenue", "100.000.000VND");
         req.setAttribute("totalDaysOfCurrentMonth", getDaysOfCurrentMonth());
         req.setAttribute("username", username);
        req.getRequestDispatcher("AdminView/admin-screen/AdminDashboard.jsp").forward(req, resp);
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
        if (!position.equals("1")) {
            changePosition(position, req, resp);
        } else {
            HttpSession session = req.getSession();
            String username = (String)session.getAttribute("id");
            
            req.setAttribute("totalDaysOfCurrentMonth", getDaysOfCurrentMonth());
            
            
            
            req.setAttribute("username", username);
            req.getRequestDispatcher("AdminView/admin-screen/AdminDashboard.jsp").forward(req, resp);
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
    
    public int getDaysOfCurrentMonth(){
        LocalDate date = java.time.LocalDate.now();
        System.out.println("Today is: " + date);
        String today = date.toString();
        String[] time = today.split("-");

        int year = Integer.parseInt(time[0]);
        int month = Integer.parseInt(time[1]);
        
        LocalDate now = LocalDate.of(year, month, 1);
//        System.out.println("Totalday: " + now.lengthOfMonth());
        return now.lengthOfMonth();
    }
}
