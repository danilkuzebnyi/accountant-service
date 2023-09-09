package com.example.accountant.repository;

import com.example.accountant.model.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
    Optional<TransactionEntity> getTransactionById(int transactionId);
}
