package com.alex.shoppingcart.data;

import com.alex.shoppingcart.model.ItemModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<ItemModel, String> {

}