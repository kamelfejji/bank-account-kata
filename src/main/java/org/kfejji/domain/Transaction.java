package org.kfejji.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    private static final DecimalFormat numberFormatter;
    private static final String SEPARATOR = " | ";

    static {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(' ');
        symbols.setDecimalSeparator(',');
        numberFormatter = new DecimalFormat("#,###.00", symbols);
    }

    private final Operation operation;
    private final BigDecimal afterOperationBalance;

    public static Transaction of(Operation operation, BigDecimal balance) {
        return new Transaction(operation, balance);
    }

    private Transaction(Operation operation, BigDecimal balance) {
        this.operation = operation;
        this.afterOperationBalance = balance;
    }

    @Override
    public String toString() {
        return operation.getOperationType() + SEPARATOR
                + dateFormatter.format(operation.getDate()) + SEPARATOR
                + numberFormatter.format(operation.getAmount()) + SEPARATOR
                + numberFormatter.format(afterOperationBalance);
    }
}
