package org.kfejji;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kfejji.domain.TransactionPrinter;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

public class TransactionsHistoryTest {

    @InjectMocks
    TransactionPrinter transactionPrinter;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void print_transactions_history() {
        transactionPrinter.print(new ArrayList<>());
    }
}
