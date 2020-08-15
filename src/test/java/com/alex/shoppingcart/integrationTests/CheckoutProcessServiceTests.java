package com.alex.shoppingcart.integrationTests;

import com.alex.shoppingcart.model.cart.CartItemModel;
import com.alex.shoppingcart.model.cart.CartModel;
import com.alex.shoppingcart.model.ItemModel;
import com.alex.shoppingcart.model.TaxRateModel;
import com.alex.shoppingcart.service.CartService;
import com.alex.shoppingcart.service.ItemsService;
import com.alex.shoppingcart.service.TaxRateService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckoutProcessServiceTests {

    List<ItemModel> allItems;
    List<CartItemModel> itemsInCart;
    CartModel cartData;
    String cartId;
    TaxRateModel taxRate;

    @Autowired
    CartService cartService;

    @Autowired
    ItemsService itemsService;

    @Autowired
    TaxRateService taxRateService;

    @Before
    public void setup() {
        List<CartItemModel> itemsInCart = new ArrayList<>();
        CartItemModel cartItem;

        // Get all items.
        setAllItems((List) itemsService.getAllItems());

        // Select a few items to add to the cart and change their quantity.
        for (int i = 0; i < 3; i++) {
            cartItem = new CartItemModel(getAllItems().get(i).getId(), getAllItems().get(i).getPrice(), 2,
                    getAllItems().get(i).getDescription());
            itemsInCart.add(cartItem);
        }
        setItemsInCart(itemsInCart);

        // Create the Cart.
        cartData = new CartModel(getItemsInCart());

        // Save the cart.
        CartModel savedCartData = cartService.updateCart(cartData);
        setCartId(savedCartData.getId());

        // Get the tax rate.
        setTaxRate(taxRateService.getTaxRateByState("Texas"));
    }

    @Test
    public void getAllItems_Success() throws Exception {
        assertTrue(getAllItems().size() > 0);
    }

    @Test
    public void cartWasSaved_Success() throws Exception {
        assertTrue(getCartId().length() > 0);
    }

    @Test
    public void GetTaxRate_Success() throws Exception {
        assertEquals(getTaxRate().getTaxRate(), 7.5d);
    }

    public List<ItemModel> getAllItems() {
        return allItems;
    }

    public void setAllItems(List<ItemModel> allItems) {
        this.allItems = allItems;
    }

    public List<CartItemModel> getItemsInCart() {
        return itemsInCart;
    }

    public void setItemsInCart(List<CartItemModel> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    public CartModel getCart() {
        return cartData;
    }

    public void setCart(CartModel cart) {
        this.cartData = cart;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public TaxRateModel getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(TaxRateModel taxRate) {
        this.taxRate = taxRate;
    }
}