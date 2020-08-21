package com.alex.shoppingcart.integrationTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import com.alex.shoppingcart.model.cart.CartItemModel;
import com.alex.shoppingcart.model.cart.CartModel;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class CartControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createCartWIthNoItems() throws Exception {
        List<CartItemModel> cartItems = new ArrayList<>();
        // CartItemModel item = new CartItemModel();
        // item.setDescription("pc");
        // item.setItemId("333");
        // cartItems.add(item);
        CartModel cart = new CartModel();
        cart.setCartItems(cartItems);

        ResponseEntity<CartModel> response = this.restTemplate.postForEntity("http://localhost:" + port + "/cart", cart,
                CartModel.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}