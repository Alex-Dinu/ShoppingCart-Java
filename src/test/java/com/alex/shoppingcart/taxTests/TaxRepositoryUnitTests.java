package com.alex.shoppingcart.taxTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.alex.shoppingcart.data.taxRate.TaxRate;
import com.alex.shoppingcart.model.TaxRateModel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaxRepositoryUnitTests {
    
    @Test
    public void GettingTaxRateSuccess(){
        TaxRate taxRateRepo = new TaxRate();
        taxRateRepo.setState("Texas");
        TaxRateModel taxRateData = taxRateRepo.getTaxRateData();

        assertNotNull(taxRateData);
    }
}