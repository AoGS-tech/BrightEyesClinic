/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.booking;
import com.groud2.web.model.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class serviceDAO {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;
public ArrayList<service> getService() throws SQLException {
        ArrayList<service> list = new ArrayList<>();
        String sql = "SELECT * FROM service";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String serviceID = rs.getString(1);
                String service = rs.getString(2);
                String description = rs.getString(3);
                String price = rs.getString(4);
                
                service g = new service(serviceID, service, description, price);
                list.add(g);
                System.out.println("get service success");
            }
        } catch (SQLException e) {
            System.out.println("get service error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;

    }
public ArrayList<service> getService2() throws SQLException {
        ArrayList<service> list = new ArrayList<>();
        String sql = "SELECT * FROM service2";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String serviceID = rs.getString(1);
                String service = rs.getString(2);
                String description = rs.getString(3);
                String price = rs.getString(4);
                
                service g = new service(serviceID, service, description, price);
                list.add(g);
                System.out.println("get service success");
            }
        } catch (SQLException e) {
            System.out.println("get service error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;

    }
}
