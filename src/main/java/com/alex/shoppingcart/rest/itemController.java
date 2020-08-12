package com.alex.shoppingcart.rest;

import com.alex.shoppingcart.model.ItemModel;
import com.alex.shoppingcart.service.itemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import org.bson.types.ObjectId;

@RestController
@RequestMapping("/item")
@CrossOrigin // allows requests from all domains

public class itemController {

    @Autowired
    private itemService itemService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<ItemModel> getItemById(@PathVariable("id") String id) {
        return itemService.getItemById(id);
    }

}