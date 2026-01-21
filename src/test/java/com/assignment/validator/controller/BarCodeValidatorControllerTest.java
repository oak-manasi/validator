package com.assignment.validator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class BarCodeValidatorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testValidateBarCode() throws Exception {

        mockMvc.perform(post("/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"barCode\":\"AA473124829GB\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        mockMvc.perform(post("/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"barCode\":\"\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));

        mockMvc.perform(post("/validate"))
                .andExpect(status().isBadRequest());

    }
}
