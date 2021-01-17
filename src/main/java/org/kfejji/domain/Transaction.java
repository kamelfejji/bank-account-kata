package org.kfejji.domain;

import java.math.BigDecimal;

public class Transaction {

    final Operation operation;
    final BigDecimal afterOperationBalance;

    public static Transaction of(Operation operation, BigDecimal balance) {
        return new Transaction(operation, balance);
    }

    private Transaction(Operation operation, BigDecimal balance) {
        this.operation = operation;
        this.afterOperationBalance = balance;
    }

    public String print() {
        return "";
    }
}
