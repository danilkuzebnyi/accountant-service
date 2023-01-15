package com.example.accountant.controller;

import com.example.accountant.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MainControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    TransactionService transactionService;

    @BeforeEach
    public void setUp() {
        Mockito.reset(transactionService);
    }

    @Test
    void getTotalAmountByTransactionId() throws Exception {
        when(transactionService.getTotalAmountByTransactionId(1)).thenReturn(155L);

        mockMvc.perform(get("/transactions/1").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("155"));
    }
}