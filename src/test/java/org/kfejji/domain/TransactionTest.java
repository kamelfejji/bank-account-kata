package org.kfejji.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class TransactionTest {


    @Test
    public void should_print_withdrawal_transaction(){
        LocalDate date = LocalDate.of(2021, 1, 4);
        Transaction withdrawalTransaction = Transaction.of(Operation.ofWithdrawal(date,BigDecimal.valueOf(100)), BigDecimal.valueOf(200));
        //assertEquals("WithDRAWAL | ");
    }

}