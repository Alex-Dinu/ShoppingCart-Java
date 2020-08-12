package com.alex.shoppingcart.data.taxRate;

import com.alex.shoppingcart.model.TaxRateModel;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TaxRate implements TaxRateGetter {

    private String state;
    private TaxRateModel taxRateData;
    
   
    private TaxRateModel getTaxRateFromApiCall(String state){
        String uri = "http://localhost:8088/tax/" + state;
        RestTemplate restTemplate = new RestTemplate();
        TaxRateModel taxRate = restTemplate.getForObject(uri, TaxRateModel.class);
        return taxRate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TaxRateModel getTaxRateData() {
        if(this.taxRateData == null){
            setTaxRateData();
        }

        return this.taxRateData;
    }

    public void setTaxRateData() {
        this.taxRateData = getTaxRateFromApiCall(this.getState());
    }
}