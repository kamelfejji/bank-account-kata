package org.kfejji.domain;

import org.kfejji.service.printers.TransactionPrinter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;
    private final List<Transaction> transactions;
    private final TransactionPrinter transactionPrinter;

    public Account(TransactionPrinter transactionPrinter, List<Transaction> transactions) {
        this.transactionPrinter = transactionPrinter;
        this.transactions = transactions;
    }

    public String printTransactionsHistory() {
        return transactionPrinter.print(transactions);
    }

    public Transaction withdraw(BigDecimal amount) {
        requirePositiveAmount(amount);
        this.balance = balance.subtract(amount);
        return storeTransaction(Transaction.of(Operation.ofWithdrawal(LocalDate.now(), amount), getBalance()));
    }

    public Transaction deposit(BigDecimal amount) {
        requirePositiveAmount(amount);
        this.balance = balance.add(amount);
        return storeTransaction(Transaction.of(Operation.ofDeposit(LocalDate.now(), amount), getBalance()));
    }

    private Transaction storeTransaction(Transaction transaction) {
        transactions.add(transaction);
        return transaction;
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
