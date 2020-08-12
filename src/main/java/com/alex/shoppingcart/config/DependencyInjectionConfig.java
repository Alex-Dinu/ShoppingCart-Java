package com.alex.shoppingcart.config;

import com.alex.shoppingcart.data.taxRate.TaxRate;
import com.alex.shoppingcart.data.taxRate.TaxRateGetter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectionConfig {
    
    // @Bean
    // public TaxRateGetter taxRate() {
    //     return new TaxRate();
    // }
}