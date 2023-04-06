/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ao
 */
public class roomDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

    public boolean addNewRoom(String roomID, String roomName, String roomFunction, String userID) {
        String mysql = "insert into room(roomId, roomName, roomFunction, userid) values(?, ?, ?, ?);";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(mysql);
            ps.setString(1, roomID);
            ps.setString(2, roomName);
            ps.setString(3, roomFunction);
            ps.setString(4, userID);

            ps.execute();
        } catch (Exception e) {
            System.out.println("Add new room to db error: " + e.getMessage());
            return false;
        }
        return true;
    }

    public ArrayList<room> getListRoom(String search) {
        ArrayList<room> listRoom = new ArrayList<>();
        String mysql = "select * from room";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(mysql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String userID = rs.getString(2);
                String name = rs.getString(3);
                String function = rs.getString(4);

                room r = new room(id,userID, name, function);
                if (name.toLowerCase().contains(search.toLowerCase())) {
                    listRoom.add(r);
                }
            }
        } catch (Exception e) {
            System.out.println("Get list room from db error: " + e.getMessage());
            return new ArrayList<>();
        }

        return listRoom;
    }

    public ArrayList<room> getRoomByID(String roomID) {
        ArrayList<room> listRoom = new ArrayList<>();
        String mysql = "select * from room where roomID = ?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(mysql);
            ps.setString(1, roomID);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String userID = rs.getString(2);
                String name = rs.getString(3);
                String function = rs.getString(4);

                room r = new room(id,userID, name, function);
                listRoom.add(r);
            }
        } catch (Exception e) {
            System.out.println("Get list room from db error: " + e.getMessage());
            return new ArrayList<>();
        }

        return listRoom;
    }
    
    public boolean updateRoom(String roomID, String userID, String roomName, String roomFunction) {
        String mysql = "update room set roomName = ?, roomFunction = ?, userID = ? where roomId = ?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(mysql);
            ps.setString(1, roomName);
            ps.setString(2, roomFunction);
            ps.setString(3, userID);
            ps.setString(4, roomID);
            ps.execute();
        } catch (Exception e) {
            System.out.println("Update room to db error: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean deleteRoom(String roomID){
        try {
            String SQL = "delete from room where roomId = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(SQL);
            ps.setString(1, roomID);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Delete room error: " + e.getMessage());
        }
        return false;
    }
    
    public int getListRoomID(){
        try {
            String SQL = "select roomId from room";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(SQL);
            
            rs = ps.executeQuery();
            while(rs.next()) return rs.getInt(1);
        } catch (Exception e) {
            System.out.println("get last room id error: " + e.getMessage());
        }
        return 0;
    }
}
