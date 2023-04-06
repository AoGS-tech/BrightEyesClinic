/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.feedback;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class feedbackDAO {
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;
    
      public ArrayList<feedback> getFeedback() throws SQLException, IOException {
        ArrayList<feedback> list = new ArrayList<>();
        String sql = "SELECT * FROM feedback";
        try {
            
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("helllu");
                String No = rs.getString(1);
                String name= rs.getString(2);
               String Email= rs.getString(3);
                String feedbacks = rs.getString(4);
                 
               feedback f = new feedback(No, name, Email, feedbacks);
                
               list.add(f);
}
} catch (SQLException e) {

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;

    }
      
      public void insertFb(String name,  String email, String feedbacks ) throws SQLException {
       String sql = "INSERT INTO swp.`feedback`\n"
                    + "(`Name`,`Email`,`Feedback`) values (?,?,?)";       
        try {   
            System.out.println("name"+name);
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, feedbacks);
        
            
            ps.executeUpdate();
            System.out.println("Them vao thanh cong");
       
        } catch (SQLException e) {
                 System.out.println("Create error : " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
      
    } 
}
