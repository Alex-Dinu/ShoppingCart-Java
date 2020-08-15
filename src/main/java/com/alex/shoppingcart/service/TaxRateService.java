package com.alex.shoppingcart.service;

import com.alex.shoppingcart.data.taxRate.TaxRateRepository;
import com.alex.shoppingcart.model.TaxRateModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxRateService {
    @Autowired
    private TaxRateRepository taxRateRepository;
    
    public TaxRateModel getTaxRateByState(String state){
        taxRateRepository.setState(state);

        return taxRateRepository.getTaxRateData();
    }
}