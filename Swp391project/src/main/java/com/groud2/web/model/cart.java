/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model;

import com.groud2.web.DAO.glassesDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhha
 */
public class cart {
    private List<Item> cart;

    public cart() {
        this.cart = new ArrayList<>();
    }

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }
    
    public int numberOfItem(){
        return cart.size();
    }
    
    public boolean isProductInCart(String id){
        for (Item item : cart) {
            if(item.getGlass().getGlassID().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    public int getQuantityByID(String id){
        for (Item item : cart) {
            if(item.getGlass().getGlassID().equals(id)){
                return item.getQuantity();
            }
        }
        return 0;
    }
    
    public List<Item> decryptionCookiesText(List<String> cookiesText){
        for (String string : cookiesText) {
            String[] arr=string.split("-");
            glasses g = new glassesDAO().getProductInfor(arr[0]);
            int quantity=Integer.parseInt(arr[1]);
            cart.add(new Item(g, quantity));
        }
        return cart;
    }
}
