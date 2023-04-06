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
public class AdminManageRoomController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        roomDAO r = new roomDAO();
        userDAO ud = new userDAO();
        ArrayList<room> listRoom = r.getListRoom("");
        ArrayList<user> listStaff = ud.getListUser("", "");
        String mess = req.getParameter("message");

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("id");

        if (mess != null) {
            if (mess.equals("OK")) {
                mess = "Add new room successfuly!";
            } else if(mess.equals("Error")) {
                mess = "Add new room error with data!";
            }
            else if(mess.equals("updateOK")){
                mess = "Update room information successfully!";
            }
            else if(mess.equals("updateFailed")){
                mess = "Update room error with data!";
            }
            else if(mess.equals("deleteOK")){
                mess = "Delete room information successfully!";
            }
            else if(mess.equals("deleteFailed")){
                mess = "Delete room error with data!";
            }
            req.setAttribute("display", "display");
            req.setAttribute("message", mess);
        }
        
        req.setAttribute("listStaff", listStaff);
        req.setAttribute("username", username);
        req.setAttribute("listRoom", listRoom);
        req.getRequestDispatcher("AdminView/admin-screen/ManageRoom.jsp").forward(req, resp);
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
        roomDAO rd = new roomDAO();
        if (position.equals("4")) {
            int roomID = rd.getListRoomID();
            roomID++;
            String roomName = req.getParameter("newRoomName");
            String roomFunction = req.getParameter("newRoomFunction");
            String userID = req.getParameter("userID");

            String add = req.getParameter("addRoom");
            if (add != null) {
                
                if (rd.addNewRoom(String.valueOf(roomID), roomName, roomFunction, userID)) {
                    resp.sendRedirect("manageRoom?message=OK");
                } else {
                    resp.sendRedirect("manageRoom?message=Error");
                }
            }

        } else {
            changePosition(position, req, resp);
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
}
