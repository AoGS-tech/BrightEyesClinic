/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.glassesDAO;
import com.groud2.web.DAO.newsDAO;
import com.groud2.web.model.glasses;
import com.groud2.web.model.news;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class newsController extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet newsController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet newsController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("da xuat du lieu");
          newsDAO n =new newsDAO() ;       
        try {
            ArrayList<news> listNews = n.ListNews();
             request.setAttribute("listNews",listNews);
             request.getRequestDispatcher("ListNews.jsp").forward(request, response);             
        } catch (SQLException ex) {
            System.out.println("hellloooo");
            Logger.getLogger(glassesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        String newsname=request.getParameter("newsname");
        String category=request.getParameter("category");
        String authour=request.getParameter("authour");
        String date=request.getParameter("date");
        String images1=request.getParameter("images1");
        String images2=request.getParameter("images2");
        String images3=request.getParameter("images3");
        String images4=request.getParameter("images4");
        String newscontent1=request.getParameter("newscontent1");
        String newscontent2=request.getParameter("newscontent2");
        String newscontent3=request.getParameter("newscontent3");
        String newscontent4=request.getParameter("newscontent4");
        String issue1=request.getParameter("issue1");
        String issue2=request.getParameter("issue2");
        String issue3=request.getParameter("issue3");
        String issue4=request.getParameter("issue4");
        
        newsDAO n=new newsDAO();
     
        
        try {
            n.CreateNews(id,newsname,category,authour,date,images1,images2,images3,images4,newscontent1,newscontent2,newscontent3,newscontent4,issue1,issue2,issue3,issue4);
             request.getRequestDispatcher("Addnews.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(newsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
