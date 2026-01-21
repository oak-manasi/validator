package com.assignment.validator.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.validator.dto.BarcodeDTO;

@SpringBootTest
public class ValidatorServiceTest {

    @Autowired
    ValidatorService validatorService;

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "AA473124829GB, true",
            "GA141324542GB, true",
            "TQ355524544GB, true",
            "A1473124829GB, false", //first 2 char 1 alpha 1 digit
            "TQA55524544GB, false", //non-numeric serial number part
            "aa473124829GB, false", //lowercase
            "AA473124828US, false", //non GB
            "AA473124828GB, false",//chk digit wrong
            "GA141324544GB, false",//chk digit wrong
            "TQ355524549GB, false",//chk digit wrong
            "124828GB, false"// incomplete 
            })
    void testIsValidBarCode(String barCode, boolean expected) {
        BarcodeDTO barcodeDTO = new BarcodeDTO(barCode);
        assert (validatorService.isValidBarCode(barcodeDTO) == expected);
    }
}
