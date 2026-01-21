package com.assignment.validator.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.validator.dto.BarcodeAdapter;
import com.assignment.validator.dto.BarcodeDTO;

@RestController
public class BarCodeValidatorController {
  
    @Autowired
    private BarcodeAdapter barcodeAdapter;

    @PostMapping("/validate")
    public Boolean validateBarCode(@RequestBody BarcodeDTO barCode) {
        return barcodeAdapter.validateBarCode(barCode);
    }
    
}
