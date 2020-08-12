package com.alex.shoppingcart.rest;

import com.alex.shoppingcart.model.ItemModel;
import com.alex.shoppingcart.service.ItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@CrossOrigin // allows requests from all domains
public class ItemsController {

        @Autowired
        private ItemsService itemsService;

        @RequestMapping(method = RequestMethod.GET)
        public Iterable<ItemModel> findAll() {
            return itemsService.getAllItems();
        }

        @RequestMapping(method = RequestMethod.POST)
        public void addItems(@RequestBody Iterable<ItemModel> items) {
            itemsService.addItems(items);
        }
}

