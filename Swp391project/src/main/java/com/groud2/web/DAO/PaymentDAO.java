/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author anhha
 */
public class PaymentDAO {
       PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

    public boolean createBill(String userId, String name, String phone, String address, String service, String price) throws SQLException {
        String sql = "INSERT INTO payment"
                + "(`userId`,`name`,`phone`,`address`,`service`,`amount`) values (?,?,?,?,?,?)";
        try {
            System.out.println("name" + userId);
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setString(5, service);
            ps.setString(6, price);
            
            ps.executeUpdate();
            System.out.println("Them vao thanh cong");
            return true;
        } catch (SQLException e) {
            System.out.println("Create error : " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    
    
    
    }
    
    
    
    
    
}
