/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.OrderGlasses.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anhha
 */
public class OrderDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

    public void insertOrder(String glasses, String nameCustomer, String email, String phone, String shipAdress, String unitShip, float shiping, String order,double toltalmonney, String status) {
        try {
            String strSelect = "INSERT INTO `orderglasses`(`glasses`,`nameCustomer`,`email`,`phone`,`shipDAddress`,`unitship`,`shiping`,`orderdate`,`toltalmonney`,`statuss`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(strSelect);

            ps.setString(1, glasses);
            ps.setString(2, nameCustomer);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, shipAdress);
            ps.setString(6, unitShip);
            ps.setFloat(7, shiping);
            ps.setString(8, order);
            ps.setDouble(9, toltalmonney);
            ps.setString(10, status);
            ps.execute();
            System.out.println("insert  success");
        } catch (Exception e) {
            System.out.println("Insert  error:" + e.getMessage());
        }
    }

    public ArrayList<Order> getAllOrder() throws SQLException {
        ArrayList<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orderglasses";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                String glassID = rs.getString(1);
                String glassName = rs.getString(2);
                String name = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                String Address = rs.getString(6);
                String unitship = rs.getString(7);
                String shiping = rs.getString(8);
                String date = rs.getString(9);
                double  totalMoney = rs.getDouble(10);
                String status = rs.getString(11);
                String unit = "";
//                String quantity= rs.getString(9);
              if (unitship.equals("1")) {
                unit += "VNpost";
            } else if (unitship.equals("2")) {
                unit += "Giao Hang Tiet Kiem";
            } else if (unitship.equals("3")) {
                unit += "Giao hang nhanh";
            }
               
                Order g = new Order(Integer.parseInt(glassID), glassName, name, phone, email, Address, unit, Float.parseFloat(shiping), date,totalMoney, status);
                list.add(g);
            }
        } catch (SQLException e) {

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

    public void updateStatus(String id) {
        try {
            String strSelect = "UPDATE `orderglasses` SET `statuss` = 'Done' WHERE (`id` = ?)";
                    
            connection = dbc.getConnection();
            ps = connection.prepareStatement(strSelect);
            ps.setString(1, id);
            
            ps.execute();
            System.out.println("insert status order success");
        } catch (Exception e) {
            System.out.println("Insert status order error:" + e.getMessage());

        }
    }

}
