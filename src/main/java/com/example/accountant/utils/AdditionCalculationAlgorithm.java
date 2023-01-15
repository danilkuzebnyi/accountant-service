package com.example.accountant.utils;

import com.example.accountant.model.dto.TransactionDto;

public class AdditionCalculationAlgorithm extends CalculationAlgorithm {
    @Override
    public long calculateFee(TransactionDto transaction) {
        return Math.round(FeeUtils.getTotalAmount(transaction.getFees()) + transaction.getType().getCommission());
    }
}
