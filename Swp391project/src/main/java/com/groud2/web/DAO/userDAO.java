/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.Attendance;

import com.groud2.web.model.user;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class userDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

    public user checklogin(String acc, String pass) throws SQLException, IOException {

        String sql = "SELECT account,password FROM user where account=? and password =?";

        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, acc);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new user(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {

            return new user(rs.getString(1), rs.getString(2));
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return null;

    }

    public boolean checkAccount(String account) throws SQLException, IOException {

        String sql = "SELECT account FROM user where account=?  ";
        try {
            System.out.println("account " + account);
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("accccc   " + rs.getString(1));
                return true;
            }
        } catch (SQLException e) {

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return false;

    }

    public void addUser(String id, String name, String gender, String role, String email, String phone, String address, String account, String password) {
        try {
            String sql = "insert into user(userId, fullname, gender, email, phonenumber, role, address, account, password) "
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, gender);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, role);
            ps.setString(7, address);
            ps.setString(8, account);
            ps.setString(9, password);

            ps.execute();
        } catch (Exception e) {
            System.out.println("Add new staff to db error: " + e.getMessage());
        }
    }

    public ArrayList<user> getListUser(String userId, String searcName) {
        ArrayList<user> listUser = new ArrayList<>();
        try {
            String mySelect = "Select * from user";
            System.out.println("Step 1");
            connection = dbc.getConnection();
            ps = connection.prepareStatement(mySelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String fullname = rs.getString(2);
                String account = rs.getString(3);
                String password = rs.getString(4);
                String phonenumber = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                String gender = rs.getString(8);
                String dob = rs.getString(9);
                if (gender != null) {
                    if (gender.equals("0")) {
                        gender = "Female";
                    } else {
                        gender = "Male";
                    }
                }
                else {
                    gender = "Male";
                }
                String image = rs.getString(10);
                String role = rs.getString(11).toUpperCase();
                user us = new user(id, fullname, account, password, phonenumber, address, email, gender, dob, image, role);

                if (!account.equals(userId) && !(role.equals("") || role.equals("customer".toUpperCase())) && fullname.toLowerCase().contains(searcName.toLowerCase())) {
                    listUser.add(us);
                }
            }
        } catch (Exception e) {
            System.out.println("Get list user from database error: " + e.getMessage());
            return new ArrayList<>();
        }

        return listUser;
    }

    public ArrayList<user> getListCustomer(String search) {
        ArrayList<user> listUser = new ArrayList<>();
        try {
            String mySelect = "Select * from user";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(mySelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String fullname = rs.getString(2);
                String account = rs.getString(3);
                String password = rs.getString(4);
                String phonenumber = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                String gender = rs.getString(8);
                if (gender.equals("0")) {
                    gender = "Female";
                } else {
                    gender = "Male";
                }
                String dob = rs.getString(9);
                String image = rs.getString(10);
                String role = rs.getString(11);
                user us = new user(id, fullname, account, password, phonenumber, address, email, gender, dob, image, role);

                if ((role.equals("") || role.equals("customer")) && fullname.toLowerCase().contains(search.toLowerCase())) {
                    listUser.add(us);
                }
            }
        } catch (Exception e) {
            System.out.println("Get list customer from database error: " + e.getMessage());
            return new ArrayList<>();
        }

        return listUser;
    }

    public ArrayList<user> getAllByAcc(String account) throws SQLException, IOException {
        ArrayList<user> list = new ArrayList<>();
        String sql = "SELECT * FROM user where account=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            rs = ps.executeQuery();
            while (rs.next()) {
                String userID = rs.getString(1);
                String fullname = rs.getString(2);
                String acc = rs.getString(3);
                String pass = rs.getString(4);
                String phonenumber = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                String bod = rs.getString(9);
                String userimages = rs.getString(10);
                String gender = rs.getString(8);
                String role = rs.getString(11);
                if (gender.equals("1")) {
                    gender = "Male";
                } else {
                    gender = "FeMale";
                }
                user g = new user(userID, fullname, acc, pass, phonenumber, address, email, gender, bod, userimages, role);
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println("get profile error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return list;
    }

    public boolean createData(String fullname, String account, String password, String phonenumber, String address, String email, String gender, String birthofdate, String role) throws SQLException {
        String sql = "INSERT INTO user"
                + "(`fullname`,`account`,`password`,`phonenumber`,`address`,`email`,`gender`,`bod`,`role`) values (?,?,?,?,?,?,?,?,?)";
        try {
            System.out.println("name" + fullname);
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setString(2, account);
            ps.setString(3, password);
            ps.setString(4, phonenumber);
            ps.setString(5, address);
            ps.setString(6, email);
            if (gender == "Male") {
                ps.setString(7, "1");
            } else {
                ps.setString(7, "0");
            }

            ps.setString(8, birthofdate);
            ps.setString(9, role);
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

    public String getUserRole(String account) {
        try {
            String sql = "Select role from user where account = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Get user role error: " + e.getMessage());
        }
        return "";
    }

    public boolean isExisted(String id) {
        try {
            String sql = "Select * from user where userId = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Check user is existed: " + e.getMessage());
        }
        return false;
    }

    public void updateProfile(String account, String newName, String newGender, String newPhone, String newAddress, String newEmail, String newBod) {
        String strUpdate = "UPDATE swppro.user SET fullname = ?, phonenumber = ?, address = ?, email = ?, gender = ?, bod = ? WHERE account = ?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(strUpdate);
            ps.setString(1, newName);
            ps.setString(2, newPhone);
            ps.setString(3, newAddress);
            ps.setString(4, newEmail);
            if (newGender.equals("Male")) {
                ps.setString(5, "1");
            } else {
                ps.setString(5, "0");
            }
            ps.setDate(6, Date.valueOf(newBod));
            ps.setString(7, account);
            ps.executeUpdate();
            System.out.println("Update profile success");
        } catch (Exception e) {
            System.out.println("Update profile error: " + e.getMessage());
        }
    }

    public void updateProfileByAdmin(String account, String newName, String newGender, String newPhone, String newAddress, String newEmail, String newBod, String newRole) {
        String strUpdate = "UPDATE user SET fullname=?,phonenumber=?,address=?,email=?,gender=?,bod=?, role=?  WHERE account=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(strUpdate);
            ps.setString(1, newName);
            ps.setString(2, newPhone);
            ps.setString(3, newAddress);
            ps.setString(4, newEmail);
            if (newGender.equals("Male")) {
                ps.setString(5, "1");
            } else {
                ps.setString(5, "0");
            }
            ps.setDate(6, Date.valueOf(newBod));
            ps.setString(7, newRole);
            ps.setString(8, account);
            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Update profile error: " + e.getMessage());
        }

    }

    public void updateProfile2(String account, String newName, String newPhone, String newAddress, String newEmail, String newGender, String newBod) {
        String strUpdate = "UPDATE swppro.user SET fullname = ?, phonenumber = ?, address=?,email=?, gender=?,bod=? WHERE account = ?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(strUpdate);
            ps.setString(1, newName);
            ps.setString(2, newPhone);
            ps.setString(3, newAddress);
            ps.setString(4, newEmail);
            if (newGender.equals("Male")) {
                ps.setString(5, "0");
            } else {
                ps.setString(5, "1");
            }
            ps.setString(6, newBod);
            ps.setString(7, account);
            ps.executeUpdate();
            System.out.println("Update profile success");
        } catch (Exception e) {
            System.out.println("Update profile error 2: " + e.getMessage());
        }
    }

    public user checkPass(String acc, String pass) throws SQLException, IOException {

        String sql = "select * from User "
                + "where account=? and "
                + "password=?";

        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, acc);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new user(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {

            return new user(rs.getString(1), rs.getString(2));

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return null;

    }

    public ArrayList<user> getUsersByRole() throws SQLException, IOException {
        ArrayList<user> listrole = new ArrayList<>();
        String sql = "SELECT * FROM user WHERE role = 'doctor'";

        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String userID = rs.getString(1);
                String fullname = rs.getString(2);
                String acc = rs.getString(3);
                String pass = rs.getString(4);
                String phonenumber = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                String bod = rs.getString(9);
                String userimages = rs.getString(10);
                String gender = rs.getString(8);
                String role = rs.getString(11);
                if (gender.equals("1")) {
                    gender = "Male";
                } else {
                    gender = "FeMale";
                }
                user ur = new user(userID, fullname, acc, pass, phonenumber, address, email, gender, bod, userimages, role);

                listrole.add(ur);
                System.out.println("see");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listrole;
    }

    public String getUserName(String userId) {
        String name = "";
        try {
            String sql = "Select fullname from user where account = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Get user name: " + e.getMessage());
        }
        return name;
    }

    public String getUserNameByID(String userId) {
        String name = "";
        try {
            String sql = "Select fullname from user where userID = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Get user name: " + e.getMessage());
        }
        return name;
    }

    public void addUser(String id, String name, String mail) {
        try {
            String sql = "insert into user(userId, fullname,email) "
                    + " values(?, ?, ?)";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(2, mail);

            ps.execute();
        } catch (Exception e) {
            System.out.println("Add new staff to db error: " + e.getMessage());
        }
    }

    public boolean createData(String fullname, String account, String email) throws SQLException {
        String sql = "INSERT INTO `swp`.`user`\n"
                + "(`fullname`,`account`,`email`,`role`) values (?,?,?,?)";
        try {
            System.out.println("name" + fullname);
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setString(2, account);

            ps.setString(3, email);
            ps.setString(4, "customer");
            ps.executeUpdate();

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

    public String checkEmail(String email) {
        String name = "";
        try {
            String sql = "Select account from user where email = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);

            }
        } catch (Exception e) {
            System.out.println("Get user name: " + e.getMessage());

        }
        return name;
    }

    public user getUser(String account) throws SQLException {
        user g = new user();

        String sql = "SELECT * FROM user where account=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            rs = ps.executeQuery();
            while (rs.next()) {
                String userID = rs.getString(1);
                String fullname = rs.getString(2);
                String acc = rs.getString(3);
                String pass = rs.getString(4);
                String phonenumber = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                String bod = rs.getString(9);
                String userimages = rs.getString(10);
                String gender = rs.getString(8);

                if (gender.equals("1")) {
                    gender = "Male";
                } else {
                    gender = "FeMale";
                }
                g = new user(userID, fullname, acc, pass, phonenumber, address, email, gender, bod, "admin");

            }
        } catch (SQLException e) {
            System.out.println("get profile error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return g;
    }

    public user checklogin(String id) throws SQLException {
        String sql = "SELECT account,password FROM swp.user where account=? ";

        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new user(rs.getString(1));
            }
        } catch (SQLException e) {

            return new user(rs.getString(1));
        } finally {
        }
        return null;
    }

    public void updatePass(String newPass, String account) {

        String strSelect = "UPDATE user SET password=? WHERE account =?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(strSelect);
            ps.setString(1, newPass);
            ps.setString(2, account);
            ps.executeUpdate();
            System.out.println("Update password success");
            System.out.println("New Pass: " + newPass);
        } catch (Exception e) {
            System.out.println("Update new pass error" + e.getMessage());
        }
    }

    public boolean checkEmailRegister(String email) throws SQLException {
        String sql = "SELECT account FROM user where email=?  ";
        try {
            System.out.println("account " + email);
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("accccc   " + rs.getString(1));
                return true;
            }
        } catch (SQLException e) {

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return false;

    }

    public boolean takeAttendance(String staffId, String date, String time) {
        String sql = "Insert into attendance(staffID, date, time) values(? ,?, ?)";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
//                ps.setString(1, id);
            ps.setString(1, staffId);
            ps.setString(2, date);
            ps.setString(3, time);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Add attendance error: " + e.getMessage());
        }
        return false;
    }

    // get list history of attendance by date, staffId
    public ArrayList<Attendance> listAttendance(String date, String staffId) {
        ArrayList<Attendance> list = new ArrayList<Attendance>();
        String sql = "SELECT * FROM attendance where staffId = ? and date = ?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, staffId);
            ps.setString(2, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
//                String staff = rs.getString(2);
//                String atDate = rs.getString(3);
                String time = rs.getString(4);
                Attendance at = new Attendance(id, staffId, date, time);
                list.add(at);
            }
        } catch (SQLException e) {
            System.out.println("Get attendance history error: " + e.getMessage());
        }
        return list;
    }

    public Attendance getAttendanceByID(String attID) {
        String sql = "Select * from attendance where attendanceID = ?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, attID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Attendance(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Get total attendance error: " + e.getMessage());
        }
        return null;
    }

    // count total attendance
    public int getLastID() {
        String sql = "Select Count(attendanceID) from attendance";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Get total attendance error: " + e.getMessage());
        }
        return 0;
    }

    public String getUserPhone(String userId) {
        String name = "";
        try {
            String sql = "Select phonenumber from user where account = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Get phonenumber name: " + e.getMessage());
        }
        return name;
    }

    public String getUserEmail(String userId) {
        String name = "";
        try {
            String sql = "Select email from user where account = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Get email user: " + e.getMessage());
        }
        return name;
    }

    public ArrayList<user> getAllByPhone(String phone) throws SQLException, IOException {
        ArrayList<user> list = new ArrayList<>();
        String sql = "SELECT * FROM user where PhoneNumber=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            while (rs.next()) {
                String userID = rs.getString(1);
                String fullname = rs.getString(2);
                String acc = rs.getString(3);
                String pass = rs.getString(4);
                String phonenumber = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                String bod = rs.getString(9);
                String userimages = rs.getString(10);
                String gender = rs.getString(8);
                String role = rs.getString(11);
                if (gender.equals("1")) {
                    gender = "Male";
                } else {
                    gender = "FeMale";
                }
                user g = new user(userID, fullname, acc, pass, phonenumber, address, email, gender, bod, userimages, role);
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println("get profile error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return list;
    }

    public int getIdbyPhone(String phone) {
        int userId = 0;
        try {
            String sql = "SELECT userId FROM user WHERE phonenumber = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            while (rs.next()) {
                userId = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Get userId: " + e.getMessage());
        }
        return userId;
    }

    public int getIdbyAccount(String account) {
        int userId = 0;
        try {
            String sql = "Select userId from user where account = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            rs = ps.executeQuery();
            while (rs.next()) {
                userId = rs.getInt(1);

            }
        } catch (Exception e) {
            System.out.println("Get userId: " + e.getMessage());

        }
        return userId;

    }

    public boolean checkExistUser(String email, String phone) throws SQLException {
        Connection conn = dbc.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean exist = false;
        try {
            String sql = "SELECT COUNT(*) AS count FROM user WHERE email = ? OR phonenumber = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, phone);
            rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    exist = true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return exist;
    }

    public user getUserbyID123(String userID) throws SQLException {
        user g = new user();

        String sql = "SELECT * FROM user where userID=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                userID = rs.getString(1);
                String fullname = rs.getString(2);
                String acc = rs.getString(3);
                String pass = rs.getString(4);
                String phonenumber = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                String bod = rs.getString(9);
                String userimages = rs.getString(10);
                String gender = rs.getString(8);

                if (gender.equals("1")) {
                    gender = "Male";
                } else {
                    gender = "FeMale";
                }
                g = new user(userID, fullname, acc, pass, phonenumber, address, email, gender, bod, "admin");

            }
        } catch (SQLException e) {
            System.out.println("get profile error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return g;
    }
}
