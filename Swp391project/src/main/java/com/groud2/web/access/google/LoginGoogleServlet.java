/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.groud2.web.access.google;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author anhha
 */
@WebServlet("/loginwithgoogle")
public class LoginGoogleServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public LoginGoogleServlet() {
    super();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String code = request.getParameter("code");
    if (code == null || code.isEmpty()) {
      RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");
      dis.forward(request, response);
    } else {
        HttpSession session = request.getSession();
      String accessToken = GoogleUtils.getToken(code);
      GoogleUser user  = GoogleUtils.getUserInfo(accessToken);
      session.setAttribute("id", user.getId());
      session.setAttribute("name", user.getName());
      session.setAttribute("email", user.getEmail());
        System.out.println("hello"+user.getId());
      response.sendRedirect("home");
    }
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}