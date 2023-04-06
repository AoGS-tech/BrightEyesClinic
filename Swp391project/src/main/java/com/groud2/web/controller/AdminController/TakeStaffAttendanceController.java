/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.Attendance;
import com.groud2.web.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ao
 */
public class TakeStaffAttendanceController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        // set real time date and time
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = f2.format(localDate);
        String currentTime = f1.format(localDate);

        HttpSession session = req.getSession();
        String staffAccount = (String) session.getAttribute("staffAccount");
        userDAO ud = new userDAO();
        user u = null;
        try {
            u = ud.getUser(staffAccount);
        } catch (SQLException ex) {
            Logger.getLogger(TakeStaffAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<Attendance> Att = ud.listAttendance(today, u.getUserId());

        String takeAtt = req.getParameter("submitAttendance");
        String search = req.getParameter("searchDate");

        if (takeAtt != null) {
            String date = req.getParameter("date");
            String time = req.getParameter("time");

            if (isInThePast(date, time) == false) {
                req.setAttribute("message", "You can not take attendance for future!\nPlease check again date and time!");
                req.setAttribute("today", today);
                req.setAttribute("nowTime", currentTime);
                req.setAttribute("listAtt", Att);
                req.setAttribute("staffName", u.getFullname());
                req.setAttribute("staffAccount", staffAccount);
                req.getRequestDispatcher("AdminView/admin-screen/TakeStaffAttendance.jsp").forward(req, resp);
            } else {
                int id = ud.getLastID();
                if (ud.takeAttendance(u.getUserId(), date, time)) {
                    resp.sendRedirect("manageStaff");
                } else {
                    req.setAttribute("message", "Oh no! There are some errors occur during your attendance action!\nPlease check clearly information!");
                    req.setAttribute("today", today);
                    req.setAttribute("nowTime", currentTime);
                    req.setAttribute("listAtt", Att);
                    req.setAttribute("staffName", u.getFullname());
                    req.setAttribute("staffAccount", staffAccount);
                    req.getRequestDispatcher("AdminView/admin-screen/TakeStaffAttendance.jsp").forward(req, resp);
                }
            }
        }

        if (search != null) {
            String dateSearch = req.getParameter("searchDateValue");
            Att = ud.listAttendance(dateSearch, u.getUserId());
            req.setAttribute("today", today);
            req.setAttribute("nowTime", currentTime);
            req.setAttribute("listAtt", Att);
            req.setAttribute("staffName", u.getFullname());
            req.setAttribute("staffAccount", staffAccount);
            req.getRequestDispatcher("AdminView/admin-screen/TakeStaffAttendance.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        userDAO ud = new userDAO();
        String adminAccount = (String) session.getAttribute("id");
        String role = "";
        if (adminAccount != null) {
            role = ud.getUserRole(adminAccount);
        }
        if (adminAccount == null || !role.equals("admin")) {
            req.getRequestDispatcher("AdminView/admin-screen/PageDefault.jsp").forward(req, resp);
        } else {
            // set real time date and time
            LocalDateTime localDate = LocalDateTime.now();
            DateTimeFormatter f1 = DateTimeFormatter.ofPattern("HH:mm");
            DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String today = f2.format(localDate);
            String currentTime = f1.format(localDate);
            // get staff account
            String staffAccount = req.getParameter("staffAccount");

            user u = null;
            try {
                u = ud.getUser(staffAccount);
            } catch (SQLException ex) {
                Logger.getLogger(TakeStaffAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
            }

            ArrayList<Attendance> Att = ud.listAttendance(today, u.getUserId());
            System.out.println("list att size = " + Att.size());
            if (Att.size() == 0) {
                req.setAttribute("block", "false");
            } else {
                String lastAttendanceTime = Att.get(Att.size() - 1).getTime();
                LocalTime nowTimeX = LocalTime.now();
                LocalTime lastTimeLocal = LocalTime.parse(lastAttendanceTime);
                LocalTime minusTime = nowTimeX.minusMinutes(5);

                System.out.println("lastAttendanceTime = " + lastAttendanceTime);
                if (minusTime.compareTo(lastTimeLocal) <= 0) {
                    req.setAttribute("block", "true");
                    System.out.println("set true");
                } else {
                    req.setAttribute("block", "false");
                    System.out.println("set false");
                }
            }
            session.setAttribute("staffAccount", staffAccount);

            req.setAttribute("today", today);
            req.setAttribute("nowTime", currentTime);
            req.setAttribute("listAtt", Att);
            req.setAttribute("staffName", u.getFullname());
            req.setAttribute("staffAccount", staffAccount);
            req.getRequestDispatcher("AdminView/admin-screen/TakeStaffAttendance.jsp").forward(req, resp);
        }
    }

    public boolean isInThePast(String date, String time) {
        LocalDate now = LocalDate.now();
        LocalDate inputDate = LocalDate.parse(date);

        LocalTime current = LocalTime.now();
        LocalTime inputTime = LocalTime.parse(time);

        if (inputDate.compareTo(now) > 0) {
            return false;
        } else if (inputDate.compareTo(now) == 0 && inputTime.compareTo(current) > 0) {
            return false;
        }
        return true;
    }
}
