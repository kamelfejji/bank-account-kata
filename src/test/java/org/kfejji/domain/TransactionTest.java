package org.kfejji.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {


    @Test
    public void should_print_withdrawal_transaction() {

        //Given
        Transaction withdrawalTransaction = Transaction.of(Operation.ofWithdrawal(LocalDate.of(2021, 1, 7), BigDecimal.valueOf(100.00)), BigDecimal.valueOf(200.00));

        //when
        final String transactionOutput = withdrawalTransaction.print();

        //Then
        assertEquals(OperationType.WITHDRAWAL.name() + " | 7/01/2021 | 100,00 | 200,00", transactionOutput);
    }

    @Test
    public void should_print_deposit_transaction() {

        //Given
        Transaction withdrawalTransaction = Transaction.of(Operation.ofDeposit(LocalDate.of(2021, 1, 14), BigDecimal.valueOf(3000.00)), BigDecimal.valueOf(5000.00));

        //when
        final String transactionOutput = withdrawalTransaction.print();

        //Then
        assertEquals(OperationType.DEPOSIT.name() + " | 14/01/2021 | 3 000,00 | 5 000,00", transactionOutput);
    }

}