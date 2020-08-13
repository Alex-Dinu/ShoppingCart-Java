package com.alex.shoppingcart.taxTests;

import org.junit.runner.RunWith;

import com.alex.shoppingcart.data.taxRate.TaxRate;
import com.alex.shoppingcart.model.TaxRateModel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class ItemControllerTests {

    @Test
    public void GetItyemSuccess(){
        // TaxRate taxRateRepo = new TaxRate();
        // taxRateRepo.setState("Texas");
        // TaxRateModel taxRateData = taxRateRepo.getTaxRateData();

        // assertNotNull(taxRateData);
    }
}