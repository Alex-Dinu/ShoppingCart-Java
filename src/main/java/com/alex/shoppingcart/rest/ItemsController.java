package com.alex.shoppingcart.rest;

import com.alex.shoppingcart.model.ItemModel;
import com.alex.shoppingcart.service.ItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/items")
@CrossOrigin // allows requests from all domains
@Tag(name = "Items Controller", description = "Lets consumers manage bulk item data.")

public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @Operation(summary = "Retriev all shopping items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All shopping items were retrieved.", content = @Content(schema = @Schema(implementation = ItemModel.class))) })
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<ItemModel> findAll() {
        return itemsService.getAllItems();
    }

    @Operation(summary = "Add a list\\array of shopping items.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All shopping items were added.", content = @Content(schema = @Schema(implementation = ItemModel.class))) })
    @RequestMapping(method = RequestMethod.POST)
    public void addItems(@RequestBody Iterable<ItemModel> items) {
        itemsService.addItems(items);
    }
}
