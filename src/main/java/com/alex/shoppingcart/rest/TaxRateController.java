package com.alex.shoppingcart.rest;

import com.alex.shoppingcart.model.TaxRateModel;
import com.alex.shoppingcart.service.TaxRateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/tax")
@CrossOrigin // allows requests from all domains
@Tag(name = "Tax Controller", description = "Get tax rate data.")

public class TaxRateController {

    @Autowired
    private TaxRateService taxRateService;

    @Operation(summary = "Get tax rate by state.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tax rate for the state.", content = @Content(schema = @Schema(implementation = TaxRateModel.class))) })
    @RequestMapping(method = RequestMethod.GET, value = "/{state}")
    public ResponseEntity<TaxRateModel> getTaxRate(@PathVariable("state") String state) {
        return new ResponseEntity<TaxRateModel>(taxRateService.getTaxRateByState(state), HttpStatus.OK);

    }
}