package com.assignment.validator.service;

import org.springframework.stereotype.Service;

import com.assignment.validator.dto.BarcodeDTO;

@Service
public class ValidatorService {    

    public boolean isValidBarCode(BarcodeDTO barCodeDTO) {
        String barCode = barCodeDTO.getBarCode();

        // Check if the barcode starts with 2 alphabets, followed by 9 digits, followed by GB
        if (!barCode.matches("[A-Z]{2}[0-9]{9}GB")) {
            return false;
        }

        // Extract the first 8 digits and the check digit
        String firstEightDigits = barCode.substring(2, 10);
        char checkDigitChar = barCode.charAt(10);
        int checkDigit = Character.getNumericValue(checkDigitChar);

        // Calculate the expected check digit
        int expectedCheckDigit = getCheckDigit(Integer.parseInt(firstEightDigits));

        // Compare the calculated check digit with the provided check digit
        return checkDigit == expectedCheckDigit;

    }

    private int getCheckDigit(int num) {
        // Get S10 check digit
        int[] weights = { 8, 6, 4, 2, 3, 5, 9, 7 };
        int sum = 0;

        // Format number as 8 digits with leading zeros
        String formatted = String.format("%08d", num);

        for (int i = 0; i < formatted.length(); i++) {
            int digit = Character.getNumericValue(formatted.charAt(i));
            sum += weights[i] * digit;
        }

        int chkDigit = 11 - (sum % 11);

        if (chkDigit == 10) {
            chkDigit = 0;
        } else if (chkDigit == 11) {
            chkDigit = 5;
        }

        return chkDigit;
    }
}
