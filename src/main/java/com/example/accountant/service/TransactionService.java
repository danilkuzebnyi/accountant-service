package com.example.accountant.service;

import com.example.accountant.model.dto.TransactionDto;
import com.example.accountant.model.entity.TransactionEntity;
import com.example.accountant.repository.TransactionRepository;
import com.example.accountant.utils.CalculationAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Returns a total fee for a transaction with passed id.
     *
     * @param transactionId  id of the transaction
     * @return total fee for given transaction
     *
     * @throws IllegalArgumentException if there is no transaction for given transactionId
     */
    public long getTotalAmountByTransactionId(int transactionId) {
        Optional<TransactionEntity> transaction = transactionRepository.getTransactionById(transactionId);
        if (transaction.isEmpty()) {
            throw new IllegalArgumentException("There is no such transaction");
        }
        CalculationAlgorithm calculationAlgorithm = CalculationAlgorithm.getCalculationAlgorithm(transaction.get().getType().getName());
        return calculationAlgorithm.calculateFee(new TransactionDto(transaction.get()));
    }
}
