/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.glassesDAO;
import com.groud2.web.model.glasses;
import jakarta.servlet.ServletException;
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
 * @author Ao
 */
public class AdminAddNewGlassController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        String id = req.getParameter("glassID");
        String name = req.getParameter("glassName");
        String color = req.getParameter("glassColor");
        String gender = req.getParameter("gender");
        String material = req.getParameter("glassMaterial");
        String style = req.getParameter("glassStyles");
        String image = req.getParameter("glassImage");
        String price = req.getParameter("glassPrice");
        String quantity = req.getParameter("glassQuantity");

        int qt = Integer.parseInt(quantity);
        String create = req.getParameter("saveAsNew");
        String update = req.getParameter("saveAsUpdate");
        glassesDAO gd = new glassesDAO();
        System.out.println("glass ID string = " + gd.getLastID());
        int id = gd.getLastID();
//        if(gd.getLastID() != null){
//            id = Integer.parseInt(gd.getLastID());
//        }
        id++;
        System.out.println("glass ID = " + id);
        if (create != null) {
            if (gd.addNewGlass(new glasses(name, color, gender, material, style, image, price, qt))) {
                resp.sendRedirect("manageGlasses?message=addOK");
            } else {
//                req.setAttribute("glassID", id);
                req.setAttribute("glassName", name);
                req.setAttribute("glassColor", color);
                req.setAttribute("gender", gender);
                req.setAttribute("glassMaterial", material);
                req.setAttribute("glassStyles", style);
                req.setAttribute("glassImage", image);
                req.setAttribute("glassPrice", price);
                req.setAttribute("glassQuantity", quantity);
                req.setAttribute("message", "Invalid input found!\nPlease check your content again!");
                req.getRequestDispatcher("AdminView/admin-screen/AddNewGlass.jsp").forward(req, resp);
            }
        }
        
        if(update != null){
            String glassID = (String)session.getAttribute("glassesID");
            glasses g = new glasses(glassID, name, color, gender, material, style, image, price, qt);
            if(gd.updateGlasses(g)){
                resp.sendRedirect("manageGlasses?message=updateOK");
            }
            else {
//                req.setAttribute("glassID", id);
                req.setAttribute("glassName", name);
                req.setAttribute("glassColor", color);
                req.setAttribute("gender", gender);
                req.setAttribute("glassMaterial", material);
                req.setAttribute("glassStyles", style);
                req.setAttribute("glassImage", image);
                req.setAttribute("glassPrice", price);
                req.setAttribute("glassQuantity", quantity);
                req.setAttribute("message", "Invalid input found!\nPlease check your content again!");
                req.getRequestDispatcher("AdminView/admin-screen/AddNewGlass.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
        String pageType = req.getParameter("type");
        System.out.println("Page type = " + pageType);
        String getUpdateGlassID = req.getParameter("updateGlassID");
        session.setAttribute("glassesID", getUpdateGlassID);
        System.out.println("glass ID = " + getUpdateGlassID);
        if (getUpdateGlassID != null) {
            glassesDAO gd = new glassesDAO();
            glasses g = new glasses();
            try {
                g = gd.getGlassesId(getUpdateGlassID);
            } catch (SQLException ex) {
                System.out.println("get glass by id error: " + ex.getMessage());
            }
            System.out.println("glass name = " + g.getGlassName());
            req.setAttribute("glassID", g.getGlassID());
                req.setAttribute("glassName", g.getGlassName());
                req.setAttribute("glassColor", g.getColor());
                req.setAttribute("gender", g.getGender());
                req.setAttribute("glassMaterial", g.getMaterial());
                req.setAttribute("glassStyles", g.getStyle());
                req.setAttribute("glassImage", g.getImage());
                req.setAttribute("glassPrice", g.getPrice());
                req.setAttribute("glassQuantity", g.getQuantity());
                req.setAttribute("pageType", pageType);
        }
        req.getRequestDispatcher("AdminView/admin-screen/AddNewGlass.jsp").forward(req, resp);
    }

}
