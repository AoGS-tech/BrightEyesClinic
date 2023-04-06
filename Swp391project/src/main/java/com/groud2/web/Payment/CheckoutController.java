/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.Payment;

import com.groud2.web.DAO.OrderDAO;
import com.groud2.web.DAO.glassesDAO;
import static com.groud2.web.controller.bookingController.*;
import com.groud2.web.controller.glassesController;
import com.groud2.web.model.OrderGlasses.Cart;
import com.groud2.web.model.OrderGlasses.Order;
import com.groud2.web.model.glasses;
import com.groud2.web.service.sendMail;
import com.paypal.base.rest.PayPalRESTException;
import jakarta.mail.MessagingException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhha
 */
public class CheckoutController extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
            out.println("<title>Servlet CheckoutController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String payment = request.getParameter("payment");
        System.out.println("lsdghfrbhgr" + payment);
        if (payment.equalsIgnoreCase("default")) {
            String name = request.getParameter("name");
            String email = request.getParameter("emailOrder");
            String phone = request.getParameter("phone");
            String adress = request.getParameter("adress");
            String city = request.getParameter("city");
            String UnitShip = request.getParameter("unitShip");
            LocalDate now = LocalDate.now();
            String cityShip = "";
            String unit = "";
            if (cityShip.equals("1")) {
                cityShip += "Ha noi";
            } else if (cityShip.equals("2")) {
                cityShip += "Ho Chi Minh";
            } else if (cityShip.equals("3")) {
                cityShip += "Can Tho";
            } else if (cityShip.equals("4")) {
                cityShip += "Lao Cai";
            } else if (cityShip.equals("5")) {
                cityShip += "Ha Tinh";
            } else if (cityShip.equals("6")) {
                cityShip += "Da Nang";
            }
            if (unit.equals("1")) {
                unit += "VNpost";
            } else if (unit.equals("2")) {
                unit += "Giao Hang Tiet Kiem";
            } else if (cityShip.equals("3")) {
                unit += "Giao hang nhanh";
            }

            if (!checkValidate(name, email, phone, adress)) {
                request.setAttribute("error", "Error value, please enter again! ");
                request.getRequestDispatcher("Cart.jsp").forward(request, response);
            } else {
                glassesDAO g = new glassesDAO();

                ArrayList<glasses> list;

                try {
                    list = g.getAllglasses();
                    HttpSession session = request.getSession();
                    String idCustom = String.valueOf(session.getAttribute("id"));
                    Cookie[] arr = request.getCookies();
                    String txt = "";
                    if (arr != null) {
                        for (Cookie c : arr) {
                            if (c.getName().equals("cart")) {
                                txt += c.getValue();

                            }
                        }
                    }
                    Cart cart = new Cart(txt, list);
                    
                    if (txt.isEmpty()) {
                        request.setAttribute("error", "Cart is empty! ");
                        request.getRequestDispatcher("Cart.jsp").forward(request, response);
                    }
                    Order o = new Order(cart, idCustom, adress, cityShip, unit, 3, 0, null, null, "Wait for confirmation");
                    OrderDAO od = new OrderDAO();
                    od.insertOrder(o.getCart().getListname(), name, email, phone, (adress + cityShip), UnitShip, 3, String.valueOf(now),cart.getTotalMoney()+3, "Wait for confirmation");
                    String success = "Order Success";
                    sendMail.MailResetPassword(email, success);
                    request.setAttribute("nofi", success);

                    request.getRequestDispatcher("home.jsp").forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MessagingException ex) {
                    Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {
            glassesDAO g = new glassesDAO();
            ArrayList<glasses> list;
            try {
                list = g.getAllglasses();
                Cookie[] arr = request.getCookies();
                String txt = "";
                if (arr != null) {
                    for (Cookie c : arr) {
                        if (c.getName().equals("cart")) {
                            txt += c.getValue();

                        }
                    }
                }
                HttpSession session = request.getSession();

                Cart cart = new Cart(txt, list);
                Order o = new Order(cart, 3, 0);
                PaymentServices paymentServices = new PaymentServices();
                String approvalLink;
                try {
                    approvalLink = paymentServices.authorizePayment(o);
                    response.sendRedirect(approvalLink);
                } catch (PayPalRESTException ex) {
                    Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
            }

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

    private boolean checkValidate(String name, String email, String phone, String adress) {
        boolean isValid = true;
        if (!isValidName(name) || !isValidEmail(email) || !isValidPhoneNumber(phone)) {
            isValid = false;
        }
        return isValid;
    }

}
