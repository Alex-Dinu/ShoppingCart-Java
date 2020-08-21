package com.alex.shoppingcart.model.cart;

public class CartItemModel {

    private String itemId;
    private double price;
    private int quantity = 1;
    private String description;

    public CartItemModel(String itemId, double price, int quantity, String description) {
        this.itemId = itemId;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public CartItemModel() {
    }

    public String getItemId() {
        return itemId.toString();
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}