package com.alex.shoppingcart.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import com.alex.shoppingcart.model.cart.CartModel;
import com.alex.shoppingcart.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin // allows requests from all domains
@Tag(name = "Cart Controller", description = "Manage Shopping Cart data.")

public class CartController {

    @Autowired
    private CartService cartService;

    @Operation(summary = "Get an existing cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cart data is returned.", content = @Content(schema = @Schema(implementation = CartModel.class))) })

    @GetMapping(value = "/{id}")
    public ResponseEntity<CartModel> getCartById(@PathVariable("id") String id) {
        CartModel cartData = cartService.getCartById(id);

        if (cartData.getId().length() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CartModel>(cartData, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CartModel> updateCart(@RequestBody CartModel cartData) {
        CartModel updatedCartData = cartService.updateCart(cartData);

        return new ResponseEntity<CartModel>(updatedCartData, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable("id") String id) {
        cartService.deleteCart(id);
    }
}