package com.alex.shoppingcart.service;

import com.alex.shoppingcart.data.cart.CartRepository;
import com.alex.shoppingcart.model.cart.CartModel;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // public CartModel createCart(CartModel cartData) {
    // return cartRepository.insert(cartData);
    // }

    public CartModel getCartById(String cartId) {
        return cartRepository.findById(new ObjectId(cartId)).get();
    }

    public void deleteCart(String cartId) {
        cartRepository.deleteById(new ObjectId(cartId));
    }

    public CartModel updateCart(CartModel cartData) {
        return cartRepository.save(cartData);
    }

}