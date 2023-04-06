/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.news;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class newsDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

    public ArrayList<news> ListNews() throws SQLException {
        ArrayList<news> list = new ArrayList<>();
        String sql = " SELECT  newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4 FROM news \n";

        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String newsname = rs.getString(1);
                String category = rs.getString(2);
                String authour = rs.getString(3);
                String datepublic = rs.getString(4);
                String images1 = rs.getString(5);
                String images2 = rs.getString(6);
                String images3 = rs.getString(7);
                String images4 = rs.getString(8);
                String newscontent1 = rs.getString(9);
                String newscontent2 = rs.getString(10);
                String newscontent3 = rs.getString(11);
                String newscontent4 = rs.getString(12);
                String issue1 = rs.getString(13);
                String issue2 = rs.getString(14);
                String issue3 = rs.getString(15);
                String issue4 = rs.getString(16);
                news n = new news(newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4);
                list.add(n);

            }
        } catch (SQLException e) {
            System.out.println(" error : " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;

    }

    public ArrayList<news> getSingle(String newsname) throws SQLException {
        System.out.println("getSingle ");
        ArrayList<news> list = new ArrayList<>();
        String sql = " SELECT  newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4 FROM news where newsname=? ";

        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, newsname);
            rs = ps.executeQuery();
            while (rs.next()) {
                newsname = rs.getString(1);
                String category = rs.getString(2);
                String authour = rs.getString(3);
                String datepublic = rs.getString(4);
                String images1 = rs.getString(5);
                String images2 = rs.getString(6);
                String images3 = rs.getString(7);
                String images4 = rs.getString(8);
                String newscontent1 = rs.getString(9);
                String newscontent2 = rs.getString(10);
                String newscontent3 = rs.getString(11);
                String newscontent4 = rs.getString(12);
                String issue1 = rs.getString(13);
                String issue2 = rs.getString(14);
                String issue3 = rs.getString(15);
                String issue4 = rs.getString(16);
                news n = new news(newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4);
                System.out.println("image" + datepublic);
                list.add(n);

            }
        } catch (SQLException e) {
            System.out.println(" error : " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

    public boolean CreateNews(String id, String newsname, String category, String authour, String date, String images1, String images2, String images3, String images4, String newscontent1, String newscontent2, String newscontent3, String newscontent4, String issue1, String issue2, String issue3, String issue4) throws SQLException {
        String sql = "INSERT INTO `swp`.`news`\n"
                + "(`newsId`,\n"
                + "`newsname`,\n"
                + "`category`,\n"
                + "`authour`,\n"
                + "`datepublic`,\n"
                + "`images1`,\n"
                + "`images2`,\n"
                + "`images3`,\n"
                + "`images4`,\n"
                + "`newscontent1`,\n"
                + "`newscontent2`,\n"
                + "`newscontent3`,\n"
                + "`newscontent4`,\n"
                + "`issue1`,\n"
                + "`issue2`,\n"
                + "`issue3`,\n"
                + "`issue4`)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, newsname);
            ps.setString(3, category);
            ps.setString(4, authour);
            ps.setString(5, date);
            ps.setString(6, images1);
            ps.setString(7, images2);
            ps.setString(8, images3);
            ps.setString(9, images4);
            ps.setString(10, newscontent1);
            ps.setString(11, newscontent2);
            ps.setString(12, newscontent3);
            ps.setString(13, newscontent4);
            ps.setString(14, issue1);
            ps.setString(15, issue2);
            ps.setString(16, issue3);
            ps.setString(17, issue4);
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

    public ArrayList<news> getCategory(String category) throws SQLException {
        ArrayList<news> listcategory = new ArrayList<>();
        String sql = " SELECT  newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4 FROM news where category=? ";

        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, category);
            rs = ps.executeQuery();
            while (rs.next()) {
                category = rs.getString(2);
                String newsname = rs.getString(1);
                String authour = rs.getString(3);
                String datepublic = rs.getString(4);
                String images1 = rs.getString(5);
                String images2 = rs.getString(6);
                String images3 = rs.getString(7);
                String images4 = rs.getString(8);
                String newscontent1 = rs.getString(9);
                String newscontent2 = rs.getString(10);
                String newscontent3 = rs.getString(11);
                String newscontent4 = rs.getString(12);
                String issue1 = rs.getString(13);
                String issue2 = rs.getString(14);
                String issue3 = rs.getString(15);
                String issue4 = rs.getString(16);
                news n = new news(newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4);
                System.out.println("image" + datepublic);
                listcategory.add(n);

            }
        } catch (SQLException e) {
            System.out.println(" error : " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return listcategory;

    }

    public ArrayList<news> getchar(String search) throws SQLException {
        ArrayList<news> listSearchValue = new ArrayList<>();
        String sql = " SELECT  newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4 FROM news where newsname like ? ";
        System.out.println("HJelalsd"+search);
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
             ps.setString(1, "%"+search+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String newsname = rs.getString(1);
                String category = rs.getString(2);
                String authour = rs.getString(3);
                String datepublic = rs.getString(4);
                String images1 = rs.getString(5);
                String images2 = rs.getString(6);
                String images3 = rs.getString(7);
                String images4 = rs.getString(8);
                String newscontent1 = rs.getString(9);
                String newscontent2 = rs.getString(10);
                String newscontent3 = rs.getString(11);
                String newscontent4 = rs.getString(12);
                String issue1 = rs.getString(13);
                String issue2 = rs.getString(14);
                String issue3 = rs.getString(15);
                String issue4 = rs.getString(16);
                news n = new news(newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4);
                System.out.println("image" + datepublic);
                listSearchValue.add(n);

            }
        } catch (SQLException e) {
            System.out.println(" error : " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return listSearchValue;

    }

}
