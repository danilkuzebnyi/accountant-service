package com.example.accountant.utils;

import com.example.accountant.model.dto.FeeDto;
import java.util.Set;

public class FeeUtils {
    public static double getTotalAmount(Set<FeeDto> fees) {
        return fees.stream().mapToDouble(FeeDto::getAmount).sum();
    }
}
