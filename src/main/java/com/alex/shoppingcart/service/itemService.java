package com.alex.shoppingcart.service;

import com.alex.shoppingcart.customExceptions.ItemNotFoundException;
import com.alex.shoppingcart.data.ItemRepository;
import com.alex.shoppingcart.model.ItemModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.bson.types.ObjectId;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public void addItem(ItemModel item) {
        itemRepository.insert(item);
    }

    public ItemModel getItemById(String id) throws ItemNotFoundException {
        try {
            ItemModel searchedItem = itemRepository.findById(new ObjectId(id)).get();
            if (searchedItem.getId().length() == 0) {
                throw new ItemNotFoundException(id + " not found.");
            }
            return searchedItem;
        } catch (Exception e) {
            throw new ItemNotFoundException(id + " not found.", e);
        }
    }

}