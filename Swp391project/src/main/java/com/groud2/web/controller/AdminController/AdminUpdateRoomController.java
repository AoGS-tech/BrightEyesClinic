/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.roomDAO;
import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.room;
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
public class AdminUpdateRoomController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        roomDAO rd = new roomDAO();
//        String roomID = req.getParameter("roomID");
        HttpSession session = req.getSession();
        String roomID = (String)session.getAttribute("roomID");
        String userID = req.getParameter("userID");
        String roomName = req.getParameter("roomName");
        String roomFunction = req.getParameter("roomFunction");

        String update = req.getParameter("update");
        String delete = req.getParameter("delete");

        if (update != null) {

            if (rd.updateRoom(roomID, userID, roomName, roomFunction)) {
                resp.sendRedirect("manageRoom?message=updateOK");
            } else {
                resp.sendRedirect("manageRoom?message=updateFailed");
            }
        }

        if (delete != null) {
            if (rd.deleteRoom(roomID)) {
                resp.sendRedirect("manageRoom?message=deleteOK");
            } else {
                resp.sendRedirect("manageRoom?message=deleteFailed");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomID = req.getParameter("roomID");
        HttpSession session = req.getSession();
        session.setAttribute("roomID", roomID);
        roomDAO rd = new roomDAO();
        userDAO ud = new userDAO();
        ArrayList<room> getRoom = rd.getRoomByID(roomID);
        String name = ud.getUserNameByID(getRoom.get(0).getUserID());
        ArrayList<user> listStaff = ud.getListUser("", "");
        req.setAttribute("listStaff", listStaff);
        req.setAttribute("username", name);
        req.setAttribute("listRoom", getRoom);
        req.getRequestDispatcher("AdminView/admin-screen/AdminUpdateRoom.jsp").forward(req, resp);
    }

}
