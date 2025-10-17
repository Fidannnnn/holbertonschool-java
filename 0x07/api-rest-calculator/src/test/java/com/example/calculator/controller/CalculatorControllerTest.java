package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/welcome")).andReturn();
        assertEquals("Welcome to CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/addNumbers")
                .param("number1", "2.0")
                .param("number2", "3.0")).andReturn();
        assertEquals("5.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/subNumbers")
                .param("number1", "10.0")
                .param("number2", "4.0")).andReturn();
        assertEquals("6.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/divideNumbers")
                .param("number1", "5.0")
                .param("number2", "2.0")).andReturn();
        assertEquals("2.5", result.getResponse().getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/factorial")
                .param("factorial", "5")).andReturn();
        assertEquals("120", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/calculeDayBetweenDate")
                .param("localDate1", "2020-03-15")
                .param("localDate2", "2020-03-29")).andReturn();
        assertEquals("14", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/integerToBinary")
                .param("number1", "20")).andReturn();
        assertEquals("10100", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/integerToHexadecimal")
                .param("number1", "170")).andReturn();
        assertEquals("AA", result.getResponse().getContentAsString());
    }
}
