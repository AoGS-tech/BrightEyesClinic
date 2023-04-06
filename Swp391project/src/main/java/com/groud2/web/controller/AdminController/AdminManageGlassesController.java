/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.glassesDAO;
import com.groud2.web.model.glasses;
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
public class AdminManageGlassesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        glassesDAO g = new glassesDAO();
        ArrayList<glasses> listGlasses = g.getListGlass("");
        String mess = req.getParameter("message");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("id");

        if (mess != null) {
            if (mess.equals("addOK")) {
                req.setAttribute("message", "Add new glass successfully!");
            } else if (mess.equals("updateOK")) {
                req.setAttribute("message", "Update glass successfully!");
            }
            req.setAttribute("display", "display");
        }
        int pageNum = 1;
        int recordsPerPage = 6;
        int start = (pageNum - 1) * recordsPerPage;
        int totalPage = ((listGlasses.size()) / recordsPerPage) + 1;

        ArrayList<glasses> dataList = new ArrayList<>();
        int end;
        if((start + recordsPerPage) <= listGlasses.size()){
            end = start+recordsPerPage;
        }
        else {
            end = listGlasses.size();
        }
        for (int i = start; i < end; i++) {
            dataList.add(listGlasses.get(i));
        }
//        List<MyData> dataList = getData(start, recordsPerPage);

        session.setAttribute("pageNum", pageNum);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("totalPages", totalPage);
        req.setAttribute("username", username);
        req.setAttribute("listGlasses", dataList);
        req.getRequestDispatcher("AdminView/admin-screen/ManageGlass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //Get request from client
        String search = req.getParameter("searchGlass");
        String pageNumber = req.getParameter("pageNum");
        
        glassesDAO gd = new glassesDAO();
        ArrayList<glasses> listGlasses = gd.getListGlass("");
        if (search != null) {
                listGlasses = gd.getListGlass(search);
            }
            //Pagination
        int lastPageNum = (int) session.getAttribute("pageNum");
        int recordsPerPage = 6;
        int totalPage = ((listGlasses.size()) / recordsPerPage) + 1;
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
        if((start + recordsPerPage) <= listGlasses.size()){
            end = start+recordsPerPage;
        }
        else {
            end = listGlasses.size();
        }
        ArrayList<glasses> dataList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            dataList.add(listGlasses.get(i));
        }
        
        session.setAttribute("pageNum", pageNum);
        req.setAttribute("pageNum", pageNum);
        req.setAttribute("totalPages", totalPage);
        req.setAttribute("listGlasses", dataList);
        req.getRequestDispatcher("AdminView/admin-screen/ManageGlass.jsp").forward(req, resp);
    }

}
