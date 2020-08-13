package com.alex.shoppingcart.controllerTests;

import org.junit.runner.RunWith;

import com.alex.shoppingcart.model.ItemModel;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.web.WebAppConfiguration;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.http.MediaType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ItemControllerTests extends AbstractTest {

    @Test
    public void getItemById() throws Exception {

        String uri = "/item/5f352c21c1381d1d97156808";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ItemModel item = super.mapFromJson(content, ItemModel.class);
        assertTrue(item.getId().length() > 0);
    }
}