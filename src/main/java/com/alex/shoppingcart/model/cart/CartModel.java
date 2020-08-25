package com.alex.shoppingcart.model.cart;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart")
public class CartModel {

    @Id
    private ObjectId id;

    private List<CartItemModel> cartItems;

    public CartModel(List<CartItemModel> cartItems) {
        this.cartItems = cartItems;
    }

    public CartModel() {
    }

    public String getId() {
        return id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<CartItemModel> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemModel> cartItems) {
        this.cartItems = cartItems;
    }

}