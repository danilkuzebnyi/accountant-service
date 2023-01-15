package com.example.accountant.model.dto;

import com.example.accountant.model.entity.FeeEntity;

public class FeeDto {
    private final String name;
    private final double amount;

    public FeeDto(FeeEntity entity) {
        this.name = entity.getName();
        this.amount = entity.getAmount();
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}


