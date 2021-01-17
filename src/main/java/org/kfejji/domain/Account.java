package org.kfejji.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;
    private List<Transaction> transactions = new ArrayList<>();

    public String printTransactionsHistory() {
        return "";
    }

    public void withdraw(BigDecimal amount) {
        requirePositiveAmount(amount);
        this.balance = balance.subtract(amount);
        storeTransaction(Operation.ofWithdrawal(LocalDate.now(), amount), getBalance());
    }

    public void deposit(BigDecimal amount) {
        requirePositiveAmount(amount);
        this.balance = balance.add(amount);
        storeTransaction(Operation.ofDeposit(LocalDate.now(), amount), getBalance());
    }

    private void storeTransaction(Operation operation, BigDecimal balance) {
        transactions.add(Transaction.of(operation, balance));
    }

    private void requirePositiveAmount(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Unsupported amount :" + amount);
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

}
