package org.kfejji.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Operation {

    OperationType operationType;
    LocalDate date;
    BigDecimal amount;

    public static Operation ofDeposit(LocalDate date, BigDecimal amount) {
        return new Operation(OperationType.DEPOSIT, date, amount);
    }

    public static Operation ofWithdrawal(LocalDate date, BigDecimal amount) {
        return new Operation(OperationType.WITHDRAWAL, date, amount);
    }

    Operation(OperationType operationType, LocalDate date, BigDecimal amount) {
        this.operationType = operationType;
        this.date = date;
        this.amount = amount;
    }

}
