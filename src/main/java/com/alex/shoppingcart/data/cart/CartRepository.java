package com.alex.shoppingcart.data.cart;

import com.alex.shoppingcart.model.cart.CartModel;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<CartModel, ObjectId> {

}