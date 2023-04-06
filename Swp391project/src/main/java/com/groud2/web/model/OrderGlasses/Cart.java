/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model.OrderGlasses;

import com.groud2.web.model.glasses;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhha
 */
public class Cart {
    private List<Item> items;
    public Cart(){
        items = new ArrayList<>();
    }
    public List<Item> getItems(){
        return  items;
    }
    
    public int getQuantityById(String id){
        return getItemById(id).getQuantity();
    }
    private Item getItemById(String id){
        for(Item i :items){
            if(i.getGlass().getGlassID().equals(id)){
                return  i;
            }
    }
        return  null;
    }
   public String getListname(){
       String name ="Glasses: ";
       for(Item i :items){
           name +=i.getGlass().getGlassName();
       }
       return name;
   }
    public void addItem(Item t){
        if(getItemById(t.getGlass().getGlassID())!=null){
            Item m = getItemById(t.getGlass().getGlassID());
            m.setQuantity(m.getQuantity()+t.getQuantity());
            
        }else{
            items.add(t);
        }
    }
    public void removeItem(String id){
        if(getItemById(id)!=null){
            items.remove(getItemById(id));
        }
    }
    public  double getTotalMoney(){
        double t = 0;
        for(Item i :items){
            t+=(i.getQuantity()*i.getPrice());
            
        }
        return t;
    }
    private glasses getGlassesById(String id,List<glasses> list ){
        for(glasses i : list){
            if(i.getGlassID().equals(id)){
                
                return i;
            }
        }
        return null;
    }
    public Cart(String txt,List<glasses> list){
        items = new ArrayList<>();
        try{
        if(txt!=null & txt.length()!=0){
            String[] s = txt.split("/");
            for(String i :s){
               String [] n = i.split("-");
               String id = n[0];
                System.out.println("id");
               int quantity = Integer.parseInt(n[1]);
                glasses g  = getGlassesById(id, list);
                Item t = new Item(g, quantity, Double.parseDouble(g.getPrice()));
                addItem(t);
            }
                
               
            
        }}catch(NumberFormatException e){
            
        }
    }
    
}
