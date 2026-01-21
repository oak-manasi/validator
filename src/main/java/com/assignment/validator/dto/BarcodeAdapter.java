package com.assignment.validator.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.validator.service.ValidatorService;

@Component
public class BarcodeAdapter {

    @Autowired
    private ValidatorService validatorService;

    public boolean validateBarCode(BarcodeDTO barcodeDTO) {
        if (barcodeDTO == null || barcodeDTO.getBarCode() == null|| barcodeDTO.getBarCode().isEmpty()) {
            return false;
        }
        return validatorService.isValidBarCode(barcodeDTO);

    }
}
