package org.kfejji.service.printers;

import org.kfejji.domain.Transaction;

import java.util.List;
import java.util.ListIterator;

public class TransactionPrinter {

    private static final String HEADER = "Operation Type | Date  | Amount | Balance \n";

    public String print(List<Transaction> transactions) {
        StringBuilder bankStatement = new StringBuilder();
        bankStatement.append(HEADER);
        ListIterator<Transaction> transactionsIterator = transactions.listIterator(transactions.size());
        while (transactionsIterator.hasPrevious()) {
            bankStatement.append(transactionsIterator.previous().toString()).append(" \n");
        }
        return bankStatement.toString();
    }

}
