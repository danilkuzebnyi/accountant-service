package com.example.accountant.model.dto;

import com.example.accountant.model.entity.TransactionEntity;
import com.example.accountant.model.entity.TransactionTypeEntity;
import java.util.Set;
import java.util.stream.Collectors;

public class TransactionDto {
    private final TransactionTypeEntity type;
    private final Set<FeeDto> fees;

    public TransactionDto(TransactionEntity entity) {
        this.type = entity.getType();
        this.fees = entity.getFees().stream().map(FeeDto::new).collect(Collectors.toSet());
    }

    public TransactionTypeEntity getType() {
        return type;
    }

    public Set<FeeDto> getFees() {
        return fees;
    }
}
