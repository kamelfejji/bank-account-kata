package org.kfejji.domain;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountTest {

    private Account account;

    @Before
    public void init() {
        account = new Account();
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

    @Test(expected = IllegalArgumentException.class)
    public void should_not_deposit_zero_amount() {

        //Given
        BigDecimal depositAmount = BigDecimal.valueOf(0);

        //When
        account.deposit(depositAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_deposit_negative_amount() {

        //Given
        BigDecimal depositAmount = BigDecimal.valueOf(-50);

        //When
        account.deposit(depositAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_withdraw_zero_amount() {

        //Given
        BigDecimal depositAmount = BigDecimal.valueOf(0);

        //When
        account.withdraw(depositAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_withdraw_negative_amount() {

        //Given
        BigDecimal depositAmount = BigDecimal.valueOf(-50);

        //When
        account.withdraw(depositAmount);
    }

}