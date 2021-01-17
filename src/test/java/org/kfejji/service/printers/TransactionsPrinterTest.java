package org.kfejji.service.printers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kfejji.domain.Operation;
import org.kfejji.domain.Transaction;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionsPrinterTest {

    @InjectMocks
    TransactionPrinter transactionPrinter;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_print_transactions_history() {

        //Given
        final List<Transaction> transactions = new ArrayList<>();
        transactions.add(Transaction.of(Operation.ofDeposit(LocalDate.of(2021, 1, 4), BigDecimal.valueOf(1000)), BigDecimal.valueOf(1000)));
        transactions.add(Transaction.of(Operation.ofWithdrawal(LocalDate.of(2021, 1, 6), BigDecimal.valueOf(400)), BigDecimal.valueOf(600)));
        transactions.add(Transaction.of(Operation.ofDeposit(LocalDate.of(2021, 1, 12), BigDecimal.valueOf(200)), BigDecimal.valueOf(800)));

        final String expectedTransactionsHistory =
                "Operation Type | Date  | Amount | Balance \n" +
                        "DEPOSIT | 12/01/2021 | 200,00 | 800,00 \n" +
                        "WITHDRAWAL | 6/01/2021 | 400,00 | 600,00 \n" +
                        "DEPOSIT | 4/01/2021 | 1 000,00 | 1 000,00 \n";

        //When
        String transactionHistory = transactionPrinter.print(transactions);

        //Then
        assertEquals(expectedTransactionsHistory, transactionHistory);

    }
}
