package com.alex.shoppingcart.data;

import java.util.List;

import com.alex.shoppingcart.model.ItemModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemsRepository extends MongoRepository<ItemModel, ObjectId> {

    public List<ItemModel> findByDescription(String description);
}

