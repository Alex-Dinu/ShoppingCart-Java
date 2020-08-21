package com.alex.shoppingcart.rest;

import com.alex.shoppingcart.customExceptions.ItemNotFoundException;
import com.alex.shoppingcart.model.ItemModel;
import com.alex.shoppingcart.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/item")
@CrossOrigin // allows requests from all domains
@Tag(name = "Item Controller", description = "Lets consumers manage individual item data.")

public class ItemController {

    @Autowired
    private ItemService itemService;

    @Operation(summary = "Retriev an item by the Item Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item details added top the response..", content = @Content(schema = @Schema(implementation = ItemModel.class))),
            @ApiResponse(responseCode = "404", description = "Item was not found for the requested Id.") })
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ItemModel> getItemById(@PathVariable("id") String id) {
        ItemModel item;
        try {
            item = itemService.getItemById(id);
            return new ResponseEntity<ItemModel>(item, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ItemModel>(HttpStatus.NOT_FOUND);
        }
    }

}