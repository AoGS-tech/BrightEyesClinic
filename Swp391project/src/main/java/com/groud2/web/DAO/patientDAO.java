/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.patient;
import com.groud2.web.model.user;
import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class patientDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

    public void insertPatient(String IdCard,int userId, String medicalDate, String symptom, String doctorName) throws SQLException {
//        userDAO ud = new userDAO();
//        String customerAcc = " ";
//        String password = " ";
//        ud.createData(doctorName, customerAcc, password, phone, address, email, gender, bod, "customer");
        String sql = "INSERT INTO patient (IdCard,userId,medicalDate,symptom,doctorName)VALUES (?,?,?,?,?) ";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, IdCard);
            ps.setInt(2, userId);
            ps.setString(3, medicalDate);
            ps.setString(4, symptom);
            ps.setString(5, doctorName);
            ps.executeUpdate();
            System.out.println("Thêm vào database  thành công");
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void insertPatient2(String IdCard, int userId, String timeOder, String medicalDate, String symptom, String doctorName, String status) throws SQLException {
        String sql = "INSERT INTO patient (IdCard,userId,timeOrder,medicalDate,symptom,doctorName,status)VALUES (?,?,?,?,?,?,1) ";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, IdCard);
            ps.setInt(2, userId);
            ps.setString(3, timeOder);
            ps.setString(4, medicalDate);
            ps.setString(5, symptom);
            ps.setString(6, doctorName);

            ps.executeUpdate();
            System.out.println("Thêm vào database  thành công");
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public ArrayList<patient> getPatientByDay(String fullname1, String process, String datenow) throws SQLException {
        ArrayList<patient> listwattingPatient = new ArrayList<>();
        try {
            String sql = "SELECT user.fullname,patient.doctorName, user.phonenumber, user.email, user.address, patient.timeOrder, patient.medicalDate, patient.medicalTime, patient.symptom, patient.conclude, patient.medicine, patient.status, patient.process, patient.Idcard\n"
                    + "FROM patient INNER JOIN user ON patient.userId = user.userId WHERE patient.doctorName = ? AND patient.process = ? AND patient.medicalDate = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, fullname1);
            ps.setString(2, process);
            ps.setString(3, datenow);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fullname = rs.getString("fullname");
                String doctorName = rs.getString("doctorName");
                String phone = rs.getString("phonenumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String timeOrder = rs.getString("timeOrder");
                String medicalDate = rs.getString("medicalDate");
                String medicalTime = rs.getString("medicalTime");
                String symptom = rs.getString("symptom");
                String conclude = rs.getString("conclude");
                String medicine = rs.getString("medicine");
                String status = rs.getString("status");
                process = rs.getString("process");
                String Idcard = rs.getString("Idcard");

                // Kiểm tra trạng thái bệnh nhân
                if (status.equals("0")) {
                    status = "Offline";
                } else {
                    status = "Online";
                }

                // Kiểm tra tình trạng xử lý
                if (process.equals("0")) {
                    process = "Waiting";
                } else {
                    process = "Completed";
                }
                user user = new user(Idcard, fullname, phone, Idcard, phone, address, email, timeOrder, sql, status);

                // Tạo đối tượng bệnh nhân và thêm vào danh sách
                patient pa = new patient(user, datenow, Idcard, Idcard, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);
                listwattingPatient.add(pa);
            }
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return listwattingPatient;
    }

//    public ArrayList<patient> getInformationPatient(String fullname, String process, String datenow, String Idcard) throws SQLException {
//        ArrayList<patient> listInformationPatient = new ArrayList<>();
//        String sql = "SELECT user.fullname,user.phonenumber,user.email,user.address,patient.timeOrder,patient.medicalDate,patient.medicalTime,patient.symptom,conclude,medicine,patient.doctorName,patient.status,patient.process,patient.Idcard,user.gender,user.bod \n"
//                + "FROM patient INNER JOIN user  ON patient.userId=user.userId  where doctorName=? and process=? and medicalDate=? and Idcard=?";
//        try {
//            connection = dbc.getConnection();
//            ps = connection.prepareStatement(sql);
//            ps.setString(1, fullname);
//            ps.setString(2, process);
//            ps.setString(3, datenow);
//            ps.setString(4, Idcard);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                String patientName = rs.getString(1);
//                String phone = rs.getString(2);
//                String email = rs.getString(3);
//                String address = rs.getString(4);
//
//                String timeOrder = rs.getString(5);
//                String medicalDate = rs.getString(6);
//                String medicalTime = rs.getString(7);
//                String symptom = rs.getString(8);
//                String conclude = rs.getString(9);
//                String medicine = rs.getString(10);
//                String doctorName = rs.getString(11);
//                String status = rs.getString(12);
//                process = rs.getString(13);
//                Idcard = rs.getString(14);
//                String gender = rs.getString(15);
//                String bod = rs.getString(16);
//
//                if (status.equals("0")) {
//                    status = "OffLine";
//                } else {
//                    status = "Online";
//                }
//                if (process.equals("0")) {
//                    process = "Watting";
//                } else {
//                    process = "Complete";
//                }
//                patient pa = new patient(patientName, Idcard, bod, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);
//                listInformationPatient.add(pa);
//
//            }
//        } catch (SQLException e) {
//            System.out.println("get Patient error: " + e.getMessage());
//        } finally {
//            if (connection != null) {
//                connection.close();
//            }
//        }
//
//        return listInformationPatient;
//    }
    public ArrayList<patient> getInformationPatient(String fullname1, String process, String datenow, String Idcard) throws SQLException {
        ArrayList<patient> listInformationPatient = new ArrayList<>();
        String sql = "SELECT user.fullname,user.phonenumber,user.email,user.address,patient.timeOrder,patient.medicalDate,patient.medicalTime,patient.symptom,patient.conclude,patient.medicine,patient.doctorName,patient.status,patient.process,patient.IdCard,user.gender,user.bod \n"
                + "FROM patient INNER JOIN user  ON patient.userId=user.userId  where doctorName=? and process=? and medicalDate=? and IdCard=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, fullname1);
            ps.setString(2, process);
            ps.setString(3, datenow);
            ps.setString(4, Idcard);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fullname = rs.getString(1);
                String phone = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);

                String timeOrder = rs.getString(5);
                String medicalDate = rs.getString(6);
                String medicalTime = rs.getString(7);
                String symptom = rs.getString(8);
                String conclude = rs.getString(9);
                String medicine = rs.getString(10);
                String doctorName = rs.getString(11);
                String status = rs.getString(12);
                process = rs.getString(13);
                Idcard = rs.getString(14);
                String gender = rs.getString(15);
                String bod = rs.getString(16);

                if (status.equals("0")) {
                    status = "OffLine";
                } else {
                    status = "Online";
                }
                if (gender.equals("0")) {
                    gender = "Female";
                } else {
                    gender = "Male";
                }
                if (process.equals("0")) {
                    process = "Watting";
                } else {
                    process = "Complete";
                }
                user user = new user(bod, fullname, phone, bod, phone, address, email, gender, bod, status);
                //patient pa = new patient(patientName, Idcard, bod, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);
                patient pa = new patient(user, datenow, Idcard, bod, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);
                listInformationPatient.add(pa);

            }
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return listInformationPatient;
    }

    public void Successful(String processOK, String Idcard, String datenow) throws SQLException {
        String sql = " UPDATE patient SET process= ? WHERE `IdCard` = ? and `medicalDate` = ? ";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, processOK);
            ps.setString(2, Idcard);
            ps.setString(3, datenow);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }
    public void Successful1(String processOK, String Idcard, String datenow) throws SQLException {
        String sql = " UPDATE patient SET status= ? WHERE `IdCard` = ? and `medicalDate` = ? ";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, processOK);
            ps.setString(2, Idcard);
            ps.setString(3, datenow);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    } public void Successful2(String Idcard, String datenow) throws SQLException {
        String sql = " UPDATE patient SET status= 1 WHERE `IdCard` = ? and `medicalDate` = ? ";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
          
            ps.setString(1, Idcard);
            ps.setString(2, datenow);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    public ArrayList<patient> getPatientByDayOrder(String fullname, String process, String datenow, String status) throws SQLException {
        ArrayList<patient> listwattingPatient = new ArrayList<>();
        String sql = " SELECT user.fullname,user.phonenumber,user.email,user.address,patient.timeOrder,patient.medicalDate,patient.medicalTime,patient.symptom,conclude,medicine,patient.doctorName,patient.status,patient.process,patient.Idcard \n"
                + "FROM patient INNER JOIN user  ON patient.userId=user.userId where doctorName=? and process=? and medicalDate=? and status=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setString(2, process);
            ps.setString(3, datenow);
            ps.setString(4, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                 fullname = rs.getString(1);
                String phone = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);

                String timeOrder = rs.getString(5);
                String medicalDate = rs.getString(6);
                String medicalTime = rs.getString(7);
                String symptom = rs.getString(8);
                String conclude = rs.getString(9);
                String medicine = rs.getString(10);
                String doctorName = rs.getString(11);
                status = rs.getString(12);
                process = rs.getString(13);
                String Idcard = rs.getString(14);
                if (status.equals("0")) {
                    status = "OffLine";
                } else {
                    status = "Online";
                }
                if (process.equals("0")) {
                    process = "Watting";
                } else {
                    process = "Complete";
                }

                user user = new user(Idcard, fullname, phone, Idcard, phone, address, email, timeOrder, sql, medicine);
                patient pa = new patient(user, datenow, Idcard, Idcard, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);
                listwattingPatient.add(pa);
            }
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return listwattingPatient;

    }

    public ArrayList<patient> getInformationPatient(String Idcard, String medicalDate) throws SQLException {

        ArrayList<patient> listwattingPatient = new ArrayList<>();
        System.out.println("da vao den day roi");
        try {
            String sql = "SELECT patientName,phone,email,address,timeOrder,medicalDate,medicalTime,symptom,conclude,medicine,doctorName,status,process,Idcard FROM patient where Idcard=? and medicalDate=?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, Idcard);
            ps.setString(2, medicalDate);
            rs = ps.executeQuery();
            while (rs.next()) {
                String patientName = rs.getString(1);
                String phone = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);
                String timeOrder = rs.getString(5);
                medicalDate = rs.getString(6);
                String medicalTime = rs.getString(7);
                String symptom = rs.getString(8);
                String conclude = rs.getString(9);
                String medicine = rs.getString(10);
                String doctorName = rs.getString(11);
                String status = rs.getString(12);
                String process = rs.getString(13);
                Idcard = rs.getString(14);
                if (status.equals("0")) {
                    status = "OffLine";
                } else {
                    status = "Online";
                }
                if (process.equals("0")) {
                    process = "Watting";
                } else {
                    process = "Complete";
                }
//                patient pa = new patient(patientName, Idcard, patientName, phone, email, address, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);
//
//                listwattingPatient.add(pa);
                System.out.println("hay ok kok ko");
            }
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return listwattingPatient;

    }

    public void Delete(String Idcard, String medicalDate) throws SQLException {
        String sql = " delete from patient WHERE IdCard=? and medicalDate=? ";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, Idcard);
            ps.setString(2, medicalDate);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    public ArrayList<user> getPatientByDay1(String fullname1, String process, String datenow) throws SQLException {
        ArrayList<user> listwattingPatient1 = new ArrayList<>();
        try {
            String sql = "SELECT user.fullname,patient.doctorName, user.phonenumber, user.email, user.address, patient.timeOrder, patient.medicalDate, patient.medicalTime, patient.symptom, patient.conclude, patient.medicine, patient.status, patient.process, patient.Idcard\n"
                    + "FROM patient INNER JOIN user ON patient.userId = user.userId WHERE patient.doctorName = ? AND patient.process = ? AND patient.medicalDate = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, fullname1);
            ps.setString(2, process);
            ps.setString(3, datenow);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fullname = rs.getString("fullname");
                String doctorName = rs.getString("doctorName");
                String phone = rs.getString("phonenumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String timeOrder = rs.getString("timeOrder");
                String medicalDate = rs.getString("medicalDate");
                String medicalTime = rs.getString("medicalTime");
                String symptom = rs.getString("symptom");
                String conclude = rs.getString("conclude");
                String medicine = rs.getString("medicine");
                String status = rs.getString("status");
                process = rs.getString("process");
                String Idcard = rs.getString("Idcard");

                // Kiểm tra trạng thái bệnh nhân
                if (status.equals("0")) {
                    status = "Offline";
                } else {
                    status = "Online";
                }

                // Kiểm tra tình trạng xử lý
                if (process.equals("0")) {
                    process = "Waiting";
                } else {
                    process = "Completed";
                }

                // Tạo đối tượng bệnh nhân và thêm vào danh sách
                //patient pa = new patient(datenow, Idcard, Idcard, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);
                user p = new user(Idcard, fullname, phone, Idcard, phone, address, email, timeOrder, sql, status, phone);
                listwattingPatient1.add(p);
            }
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return listwattingPatient1;

    }

    public void Medical(String processOK, String Idcard, String datenow, String conclude, String medicine) throws SQLException {

        String sql = " UPDATE patient SET process= ? ,conclude=?,medicine=? WHERE `IdCard` = ? and `medicalDate` = ? ";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, processOK);
            ps.setString(2, conclude);
            ps.setString(3, medicine);
            ps.setString(4, Idcard);
            ps.setString(5, datenow);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public ArrayList<patient> getInformationPatient1(String fullname1, String process, String datenow, String Idcard) throws SQLException {
        ArrayList<patient> listInformationPatient1 = new ArrayList<>();
        String sql = "SELECT user.fullname,user.phonenumber,user.email,user.address,patient.timeOrder,patient.medicalDate,patient.medicalTime,patient.symptom,patient.conclude,patient.medicine,patient.doctorName,patient.status,patient.process,patient.IdCard,user.gender,user.bod \n"
                + "FROM patient INNER JOIN user  ON patient.userId=user.userId  where doctorName=? and process=? and medicalDate=? and IdCard=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, fullname1);
            ps.setString(2, process);
            ps.setString(3, datenow);
            ps.setString(4, Idcard);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fullname = rs.getString(1);
                String phone = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);

                String timeOrder = rs.getString(5);
                String medicalDate = rs.getString(6);
                String medicalTime = rs.getString(7);
                String symptom = rs.getString(8);
                String conclude = rs.getString(9);
                String medicine = rs.getString(10);
                String doctorName = rs.getString(11);
                String status = rs.getString(12);
                process = rs.getString(13);
                Idcard = rs.getString(14);
                String gender = rs.getString(15);
                String bod = rs.getString(16);

                if (status.equals("0")) {
                    status = "OffLine";
                } else {
                    status = "Online";
                }
                if (process.equals("0")) {
                    process = "Watting";
                } else {
                    process = "Complete";
                }
                //patient pa = new patient(patientName, Idcard, bod, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);
                patient pa = new patient(datenow, Idcard, bod, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);
                listInformationPatient1.add(pa);

            }
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return listInformationPatient1;

    }

    public ArrayList<patient> getInfor(String Idcard, String medicalDate) throws SQLException {
        ArrayList<patient> Infor = new ArrayList<>();
        String sql = "SELECT IdCard,userId,timeOrder,medicalDate,medicalTime,symptom,doctorName FROM swppro.patient where Idcard=? and medicalDate=? ";

        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, Idcard);
            ps.setString(2, medicalDate);
           
            rs = ps.executeQuery();
            while (rs.next()) {
                String IdCard = rs.getString(1);
                String userId = rs.getString(2);
                String timeOrder = rs.getString(3);
                 medicalDate = rs.getString(4);
                String medicalTime = rs.getString(5);             
                String symptom = rs.getString(6);
                String doctorName = rs.getString(7);     
                //patient pa = new patient(patientName, Idcard, bod, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);
                patient pa = new patient(userId, IdCard, userId, timeOrder, medicalDate, medicalTime, symptom, IdCard, medicalTime, doctorName, symptom, IdCard);
                Infor.add(pa);

            }
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return Infor;
    
    
    }

    public void insertPatientBy(String IdCard, String userId, String time, String medicalDate, String symptom, String doctorName) throws SQLException {
        String sql = "INSERT INTO patient (IdCard,userId,timeOrder,medicalDate,symptom,doctorName)VALUES (?,?,?,?,?,?) ";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, IdCard);
            
            ps.setString(2, userId);
            ps.setString(3, time);
            ps.setString(4, medicalDate);
            ps.setString(5, symptom);
            ps.setString(6, doctorName);
            ps.executeUpdate();
            System.out.println("Thêm vào database  thành công");
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    
    
    }

//    public void insertPatient(String IdCard, String medicalDate, String symptom, String doctorName, String userId) throws SQLException {
//        String sql = "INSERT INTO patient (IdCard,medicalDate,symptom,doctorName,userId)VALUES (?,?,?,?,?) ";
//        try {
//            connection = dbc.getConnection();
//            ps = connection.prepareStatement(sql);
//            ps.setString(1, IdCard);
//
//            ps.setString(2, medicalDate);
//            ps.setString(3, symptom);
//            ps.setString(4, doctorName);
//            ps.setString(5, userId);
//            ps.executeUpdate();
//            System.out.println("Thêm vào database  thành công");
//        } catch (SQLException e) {
//            System.out.println("Lỗi: " + e.getMessage());
//        } finally {
//            if (connection != null) {
//                connection.close();
//            }
//        }
//    }

    public ArrayList<patient> getPatientHistory(String IdCard) throws SQLException {
    ArrayList<patient> listPatientHistory = new ArrayList<>();
        try {
            String sql = "SELECT user.fullname,patient.doctorName, user.phonenumber, user.email, user.address, patient.timeOrder, patient.medicalDate, patient.medicalTime, patient.symptom, patient.conclude, patient.medicine, patient.status, patient.process, patient.Idcard\n"
                    + "FROM patient INNER JOIN user ON patient.userId = user.userId WHERE  patient.IdCard = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, IdCard);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fullname = rs.getString("fullname");
                String doctorName = rs.getString("doctorName");
                String phone = rs.getString("phonenumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String timeOrder = rs.getString("timeOrder");
                String medicalDate = rs.getString("medicalDate");
                String medicalTime = rs.getString("medicalTime");
                String symptom = rs.getString("symptom");
                String conclude = rs.getString("conclude");
                String medicine = rs.getString("medicine");
                String status = rs.getString("status");
                String process = rs.getString("process");
                String Idcard = rs.getString("Idcard");

                // Kiểm tra trạng thái bệnh nhân
                if (status.equals("0")) {
                    status = "Offline";
                } else {
                    status = "Online";
                }

                // Kiểm tra tình trạng xử lý
                if (process.equals("0")) {
                    process = "Waiting";
                } else {
                    process = "Completed";
                }
                user user = new user(Idcard, fullname, phone, Idcard, phone, address, email, timeOrder, sql, status);

                // Tạo đối tượng bệnh nhân và thêm vào danh sách
                patient pa = new patient(user, Idcard, Idcard, Idcard, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);
                        listPatientHistory.add(pa);
            }
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return listPatientHistory;   
    
    
    }

   

}
