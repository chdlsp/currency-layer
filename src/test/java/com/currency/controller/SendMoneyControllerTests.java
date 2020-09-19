package com.currency.controller;

import com.currency.application.GetCurrnetCurrencyInfoService;
import com.currency.entity.dto.CurrencyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SendMoneyController.class)
class SendMoneyControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GetCurrnetCurrencyInfoService getCurrnetCurrencyInfoService;

    @MockBean
    CurrencyDTO currencyDTO;

    @Test
    void index() throws Exception {

        mockMvc.perform(
                get("/")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }
}