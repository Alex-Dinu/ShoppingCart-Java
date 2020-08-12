package com.alex.shoppingcart.service;

import com.alex.shoppingcart.data.ItemsRepository;
import com.alex.shoppingcart.model.ItemModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    public void addItems(Iterable<ItemModel> items) {
        itemsRepository.insert(items);
    }

    public Collection<ItemModel> getAllItems() {
        return itemsRepository.findAll();
    }
}
