package com.example.accountant.controller;

import com.example.accountant.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final TransactionService transactionService;

    @Autowired
    public MainController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("transactions/{id}")
    public long getTotalAmountByTransactionId(@PathVariable("id") int transactionId) {
        return transactionService.getTotalAmountByTransactionId(transactionId);
    }
}
