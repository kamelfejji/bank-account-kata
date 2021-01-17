package org.kfejji.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kfejji.service.printers.TransactionPrinter;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;


public class AccountTest {

    @InjectMocks
    private Account account;

    @Mock
    private List<Transaction> transactions;

    @Mock
    private TransactionPrinter transactionPrinter;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_add_deposit_amount() {
        //Given
        BigDecimal initialBalance = account.getBalance();
        BigDecimal depositAmount = BigDecimal.valueOf(200);

        //When
        account.deposit(depositAmount);

        //Then
        assertEquals(initialBalance.add(depositAmount), account.getBalance());
    }

    @Test
    public void should_subtract_withdrawal_amount() {
        //Given
        BigDecimal initialBalance = account.getBalance();
        BigDecimal withdrawalAmount = BigDecimal.valueOf(100);

        //When
        account.withdraw(withdrawalAmount);

        //Then
        assertEquals(initialBalance.subtract(withdrawalAmount), account.getBalance());
    }

    @Test
    public void should_not_deposit_when_zero_amount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(BigDecimal.valueOf(0)));
    }

    @Test
    public void should_not_deposit_when_negative_amount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(BigDecimal.valueOf(-50)));
    }

    @Test
    public void should_not_withdraw_when_zero_amount() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.valueOf(0)));
    }

    @Test
    public void should_not_withdraw_when_negative_amount() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.valueOf(-50)));
    }

    @Test
    public void should_store_deposit_transaction() {
        //Given
        BigDecimal depositAmount = BigDecimal.valueOf(200);

        //When
        Transaction depositTransaction = account.deposit(depositAmount);

        //Then
        verify(transactions).add(depositTransaction);
    }

    @Test
    public void should_store_withdrawal_transaction() {
        //Given
        BigDecimal withdrawalAmount = BigDecimal.valueOf(100);

        //When
        Transaction withdrawTransaction = account.withdraw(withdrawalAmount);

        //Then
        verify(transactions).add(withdrawTransaction);
    }

    @Test
    public void should_invoke_transaction_printer_print() {
        //When
        account.printTransactionsHistory();

        //Then
        verify(transactionPrinter).print(transactions);
    }

}