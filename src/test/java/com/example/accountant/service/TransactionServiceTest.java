package com.example.accountant.service;

import com.example.accountant.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Transactional
class TransactionServiceTest {
    @Autowired
    TransactionService transactionService;

    @SpyBean
    TransactionRepository transactionRepositorySpy;

    @BeforeEach
    public void setUp() {
        Mockito.reset(transactionRepositorySpy);
    }

    @Test
    void getTotalAmountByTransactionId_RepositoryIsCalled() {
        int transactionId = 1;
        transactionService.getTotalAmountByTransactionId(transactionId);
        verify(transactionRepositorySpy).getTransactionById(transactionId);
    }

    @Test
    void getTotalAmountByTransactionId_ThrowException_IfTransactionNotExist() {
        assertThrows(IllegalArgumentException.class, () -> transactionService.getTotalAmountByTransactionId(100));
    }

    @Test
    void getTotalAmountByTransactionId_ForAdditionTransactionType() {
        assertEquals(190, transactionService.getTotalAmountByTransactionId(1));
    }

    @Test
    void getTotalAmountByTransactionId_ForMultiplicationTransactionType() {
        assertEquals(180, transactionService.getTotalAmountByTransactionId(3));
    }

    @Test
    void getTotalAmountByTransactionId_ForThirdFeeFreeTransactionType_WhenQuantityOfFeesLessThanThree() {
        assertEquals(55, transactionService.getTotalAmountByTransactionId(5));
    }

    @Test
    void getTotalAmountByTransactionId_ForThirdFeeFreeTransactionType_WhenQuantityOfFeesIsThree() {
        assertEquals(110, transactionService.getTotalAmountByTransactionId(6));
    }
}