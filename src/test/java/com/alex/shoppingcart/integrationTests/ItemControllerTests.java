package com.alex.shoppingcart.integrationTests;

import com.alex.shoppingcart.model.ItemModel;

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
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ItemControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String host = "http://localhost:";
    private final String path = "/item/";

    @Test
    public void getItemById_Success() throws Exception {
        final String testId = "5f352c21c1381d1d97156808";

        ResponseEntity<ItemModel> response = this.restTemplate.getForEntity(host + port + path + testId,
                ItemModel.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getItemById_NotFoundExceptionExpected() throws Exception {
        final String testId = "invalidId";

        ResponseEntity<ItemModel> response = this.restTemplate.getForEntity(host + port + path + testId,
                ItemModel.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
    }
}