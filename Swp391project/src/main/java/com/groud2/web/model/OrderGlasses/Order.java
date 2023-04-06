/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model.OrderGlasses;

import com.groud2.web.model.glasses;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author anhha
 */
public class Order {
    private int OrderId;
    private String Glasses;
   
    private Cart cart;
    private String phone;
    private String email;
    private String nameCustomer, ShipAddress, ShipCity, unitShip;
    private float shiping;
    private float tax;
    private String OderDate, ShippedDate;
    private double  totalMoney;
    private String Status;

    public Order() {
    }

    public Order( Cart cart, String nameCustomer, String ShipAddress, String ShipCity, String unitShip, float shiping, float tax, String OderDate, String ShippedDate, String Status) {
        
        this.cart = cart;
        this.nameCustomer = nameCustomer;
        this.ShipAddress = ShipAddress;
        this.ShipCity = ShipCity;
        this.unitShip = unitShip;
        this.shiping = shiping;
        this.tax = tax;
        this.OderDate = OderDate;
        this.ShippedDate = ShippedDate;
        this.Status = Status;
    }
 public Order( String Glasses, String nameCustomer, String ShipAddress, String unitShip, float shiping, String OderDate, String Status) {
        
        this.Glasses = Glasses;
        this.nameCustomer = nameCustomer;
        this.ShipAddress = ShipAddress;
        this.unitShip = unitShip;
        this.shiping = shiping;
        this.OderDate = OderDate;
        this.Status = Status;
    }
    public Order(int OrderId, String Glasses, String nameCustomer,String phone,String email, String ShipAddress, String unitShip, float shiping, String OderDate, String Status) {
        this.OrderId = OrderId;
        this.Glasses = Glasses;
        this.nameCustomer = nameCustomer;
        this.ShipAddress = ShipAddress;
        this.unitShip = unitShip;
        this.shiping = shiping;
        this.OderDate = OderDate;
        this.Status = Status;
        this.phone=phone;
        this.email=email;
    }
    public Order(int OrderId, String Glasses, String nameCustomer,String phone,String email, String ShipAddress, String unitShip, float shiping, String OderDate,double  totalMoney, String Status) {
        this.OrderId = OrderId;
        this.totalMoney=totalMoney;
        this.Glasses = Glasses;
        this.nameCustomer = nameCustomer;
        this.ShipAddress = ShipAddress;
        this.unitShip = unitShip;
        this.shiping = shiping;
        this.OderDate = OderDate;
        this.Status = Status;
        this.phone=phone;
        this.email=email;
    }

    public Order(Cart cart, float shiping, float tax) {
        this.cart = cart;
        this.shiping = shiping;
        this.tax = tax;
    }

    
    
    public String getShiping() {
        return  String.format("%.2f",shiping);
    }

    public void setShiping(float shiping) {
        this.shiping = shiping;
    }

    public String getTax() {
        return String.format("%.2f",tax);
    }

    public void setTax(float tax) {
        this.tax = tax;
    }
    public String getSubtotal(){
        return String.format("%.2f", cart.getTotalMoney());
    }
    public String getTotal(){
        return String.format("%.2f", cart.getTotalMoney()+tax+shiping);
    }

    

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getCustomerId() {
        return nameCustomer;
    }

    public void setCustomerId(String CustomerId) {
        this.nameCustomer = CustomerId;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public void setShipAddress(String ShipAddress) {
        this.ShipAddress = ShipAddress;
    }

    public String getShipCity() {
        return ShipCity;
    }

    public void setShipCity(String ShipCity) {
        this.ShipCity = ShipCity;
    }

    public String getUnitShip() {
        return unitShip;
    }

    public void setUnitShip(String unitShip) {
        this.unitShip = unitShip;
    }

    public String getOderDate() {
        return OderDate;
    }

    public void setOderDate(String OderDate) {
        this.OderDate = OderDate;
    }

 

    public String getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(String ShippedDate) {
        this.ShippedDate = ShippedDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getGlasses() {
        return Glasses;
    }

    public void setGlasses(String Glasses) {
        this.Glasses = Glasses;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

   
    
}
