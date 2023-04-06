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
public class AdminManageCustomerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDAO u = new userDAO();
        ArrayList<user> listCustomer = u.getListCustomer("");

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("id");
        //Pagination
        int pageNum = 1;
        int recordsPerPage = 6;
        int start = (pageNum - 1) * recordsPerPage;
        int totalPage = ((listCustomer.size()) / recordsPerPage) + 1;

        ArrayList<user> dataList = new ArrayList<>();
        int end = 0;
        if ((start + recordsPerPage) <= listCustomer.size()) {
            end = start + recordsPerPage;
        } else {
            end = listCustomer.size();
        }
        for (int i = start; i < end; i++) {
            dataList.add(listCustomer.get(i));
        }
//        List<MyData> dataList = getData(start, recordsPerPage);

        session.setAttribute("pageNum", pageNum);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("totalPages", totalPage);
        //---------------------------------------------------------------------------------
        req.setAttribute("username", username);
        req.setAttribute("listCustomer", dataList);
        req.getRequestDispatcher("AdminView/admin-screen/ManageCustomer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDAO u = new userDAO();
        ArrayList<user> listCustomer = u.getListCustomer("");
        String pageNumber = req.getParameter("pageNum");
        String search = req.getParameter("search");
        if (search != null) {
            listCustomer = u.getListCustomer(search);
        }
//        String previous

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("id");

        //Pagination
        int lastPageNum = (int) session.getAttribute("pageNum");
        int recordsPerPage = 6;
        int totalPage = ((listCustomer.size()) / recordsPerPage) + 1;
        if (pageNumber != null) {
            if (pageNumber.equals("Previous")) {
                if (lastPageNum > 1 && totalPage > 1) {
                    lastPageNum--;
                }
            } else if (pageNumber.equals("Next")) {
                if (lastPageNum < totalPage) {
                    lastPageNum++;
                }
            } else {
                int currentPage = Integer.parseInt(pageNumber);
                lastPageNum = currentPage;
            }
        }
        int pageNum = lastPageNum;
        int start = (pageNum - 1) * recordsPerPage;
        int end = 0;
        if ((start + recordsPerPage) <= listCustomer.size()) {
            end = start + recordsPerPage;
        } else {
            end = listCustomer.size();
        }
        ArrayList<user> dataList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            dataList.add(listCustomer.get(i));
        }

        session.setAttribute("pageNum", pageNum);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("totalPages", totalPage);
        //---------------------------------------------------------------------------------
        req.setAttribute("username", username);
        req.setAttribute("listCustomer", dataList);
        req.getRequestDispatcher("AdminView/admin-screen/ManageCustomer.jsp").forward(req, resp);
    }
}