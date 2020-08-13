package com.alex.shoppingcart.controllerTests;

import com.alex.shoppingcart.data.ItemRepository;
import com.alex.shoppingcart.rest.ItemController;

import com.alex.shoppingcart.service.ItemService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemUnitTests {

    // No need to start a full HTTP server.
    // Processes HHT responses using expectations.
    @Autowired
    private MockMvc mockMvc;

    // This service is a dependency for the controller at test.
    @MockBean
    ItemService itemService;

    @MockBean
    ItemRepository itemRepository;

    @MockBean
    MongoRepository mongoRepo;

    @Test
    public void getItemByIdSuccessfully() throws Exception {
        mockMvc.perform(get("/item/5f352c21c1381d1d97156808")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(content().json("[]"));

        verify(itemService, times(1)).getItemById("5f352c21c1381d1d97156808");
    }

}