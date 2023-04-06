/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.glassesDAO;
import com.groud2.web.model.OrderGlasses.Cart;
import com.groud2.web.model.OrderGlasses.Item;
import com.groud2.web.model.glasses;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhha
 */
@WebServlet(name = "ProcessCartController", urlPatterns = {"/process"})
public class ProcessCartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessCartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessCartController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        glassesDAO g = new glassesDAO();

        try {
            ArrayList<glasses> list = g.getAllglasses();
            Cookie[] arr = request.getCookies();
            String txt = "";
            if (arr != null) {
                for (Cookie c : arr) {
                    if (c.getName().equals("cart")) {
                        txt += c.getValue();
                        c.setMaxAge(0);
                        response.addCookie(c);
                    }
                }
            }
            Cart cart = new Cart(txt, list);
            String num_raw = request.getParameter("num");
            String id_raw = request.getParameter("id");
            String id;
            int num = 0;
            try {
                id = id_raw;
                glasses glass = g.getGlassesId(id);
                int numStore = glass.getQuantity();
                num = Integer.parseInt(num_raw);

                if (num == -1 && (cart.getQuantityById(id) <= 1)) {
                    cart.removeItem(id);
                } else if(num == 1) {
                   
                    if (num == 1 && cart.getQuantityById(id) >= numStore) {
                        num = 0;
                    }
                    double price = Double.parseDouble(glass.getPrice());
                    Item t = new Item(glass, num, price);
                    cart.addItem(t);
                }

            } catch (NumberFormatException e) {

            }
            List<Item> items = cart.getItems();
            txt = "";
            if (items.size() > 0) {
                txt = items.get(0).getGlass().getGlassID() + "-" + items.get(0).getQuantity();
                System.out.println("helllo"+txt);
                for (int i = 1; i < items.size(); i++) {
                    txt += "/" + items.get(i).getGlass().getGlassID() + "-" + items.get(i).getQuantity();
                }
            }
            Cookie c = new Cookie("cart", txt);
            c.setMaxAge(2 * 24 * 60 * 60);

            response.addCookie(c);
            request.setAttribute("cart", cart);
            request.getRequestDispatcher("Cart.jsp").forward(request, response);

        } catch (SQLException ex) {

            Logger.getLogger(glassesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        glassesDAO g = new glassesDAO();

        try {
            ArrayList<glasses> list = g.getAllglasses();
            Cookie[] arr = request.getCookies();
            String txt = "";
            System.out.println("acv" + arr.toString());
            if (arr != null) {
                for (Cookie c : arr) {
                    if (c.getName().equals("cart")) {
                        txt += c.getValue();
                        c.setMaxAge(0);
                        response.addCookie(c);
                    }
                }
            }
            Cart cart = new Cart(txt, list);
            String num_raw = request.getParameter("num");
            String id_raw = request.getParameter("id");

            int num = 0;

            cart.removeItem(id_raw);

            List<Item> items = cart.getItems();
            txt = "";
            if (items.size() > 0) {
                txt = items.get(0).getGlass().getGlassID() + "-" + items.get(0).getQuantity();
                for (int i = 1; i < items.size(); i++) {
                    txt += "/" + items.get(i).getGlass().getGlassID() + "-" + items.get(i).getQuantity();
                }
            }
            Cookie c = new Cookie("cart", txt);
            c.setMaxAge(2 * 24 * 60 * 60);

            response.addCookie(c);
            request.setAttribute("cart", cart);
            request.getRequestDispatcher("Cart.jsp").forward(request, response);

        } catch (SQLException ex) {

            Logger.getLogger(glassesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
