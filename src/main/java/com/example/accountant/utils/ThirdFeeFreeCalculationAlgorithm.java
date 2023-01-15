package com.example.accountant.utils;

import com.example.accountant.model.dto.FeeDto;
import com.example.accountant.model.dto.TransactionDto;
import java.util.Collections;
import java.util.stream.Collectors;

public class ThirdFeeFreeCalculationAlgorithm extends CalculationAlgorithm {
    @Override
    public long calculateFee(TransactionDto transaction) {
        double totalFee = transaction.getFees().stream().mapToDouble(FeeDto::getAmount).sum();
        double minFee = Collections.min(transaction.getFees().stream().map(FeeDto::getAmount).collect(Collectors.toList()));
        return transaction.getFees().size() > 2
                ? Math.round(totalFee - minFee)
                : Math.round(totalFee);
    }
}
