package com.techelevator.view;

public class ItemsClass {
    private String name;
    private String location;
    private Double price;
    private String type;
    private int quantity = 5;

    public ItemsClass(String name, String location, Double price, String type, int quantity){
        this.name = name;
        this.location = location;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public Double getPrice(){
        return price;
    }
    public String getType(){
        return type;
    }
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }


    public int setInventory(){


        //if item is purchased item -1

        //if quantity is 0, print SOLD OUT

        //return quantity
    }




}
