/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;
import com.groud2.web.model.overview;
import com.groud2.web.DAO.context.DBContext;
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
public class overviewDAO {

  
      PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

  
    
    public  ArrayList<overview> getAlloverview() throws SQLException, IOException {
        ArrayList<overview> list = new ArrayList<>();
        String sql = "SELECT * FROM overview";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
           
                String text1 = rs.getString(1);
                String image1= rs.getString(2);
                String text2 = rs.getString(3);
                String image2= rs.getString(4);
               
              
                overview o = new overview(text1,image1,text2,image2);
                
                list.add(o);
}
} catch (SQLException e) {

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;

    }

   
}

