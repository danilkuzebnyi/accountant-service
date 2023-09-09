package com.example.accountant.utils;

import com.example.accountant.model.dto.TransactionDto;
import com.example.accountant.model.enums.TransactionTypeEnum;

public abstract class CalculationAlgorithm {
    /**
     * Calculate total fee for given transaction.
     *
     * @param transaction  data of transaction
     * @return total fee for given transaction
     */
    public abstract long calculateFee(TransactionDto transaction);

    /**
     * Get a specific calculation algorithm depending on the type of transaction.
     *
     * @param transactionType  type of transaction
     * @return specific implementation of {@link CalculationAlgorithm} class
     */
    public static CalculationAlgorithm getCalculationAlgorithm(TransactionTypeEnum transactionType) {
        CalculationAlgorithm calculationAlgorithm = null;
        switch (transactionType) {
            case ADDITION:
                calculationAlgorithm = new AdditionCalculationAlgorithm();
                break;
            case MULTIPLICATION:
                calculationAlgorithm = new MultiplicationCalculationAlgorithm();
                break;
            case THIRD_FEE_FREE:
                calculationAlgorithm = new ThirdFeeFreeCalculationAlgorithm();
                break;
        }

        return calculationAlgorithm;
    }
}
