package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Balance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.math.BigDecimal;

public class JdbcAccountDAOTest extends TenmoDaoTests {

    private JdbcAccountDAO sut;
    private Account testAccount;

    @Before
    public void setup() {
        sut = new JdbcAccountDAO(dataSource);
        Balance testBalance = new Balance();
        testBalance.setBalance(new BigDecimal("500.00"));
        testAccount = new Account(2001, 1001, testBalance);
    }


    @Test
    public void getBalance_returns_correct_balance() {
        BigDecimal actual = sut.getBalance("user1").getBalance();
        BigDecimal expected = new BigDecimal("500.00");

        Assert.assertEquals(actual.compareTo(expected), 0);
    }

    @Test
    public void getAccountByUserID_returns_correct_account() {
        Account actual = sut.getAccountByUserID(1001);
        Account expected = testAccount;

        assertAccountsMatch(expected, actual);
    }

    @Test
    public void getAccountByAccountID_returns_correct_account() {
        Account actual = sut.getAccountByAccountID(2001);
        Account expected = testAccount;

        assertAccountsMatch(expected, actual);
    }

    @Test
    public void updateAccount_updates_account() {
        Balance balance = new Balance();
        balance.setBalance(new BigDecimal("45.22"));
        testAccount.setBalance(balance);
        sut.updateAccount(testAccount);

        Account actual = sut.getAccountByUserID(1001);
        Account expected = testAccount;

        assertAccountsMatch(expected, actual);
    }

    private void assertAccountsMatch(Account expected, Account actual) {
        Assert.assertEquals(expected.getAccountId(), actual.getAccountId());
        Assert.assertEquals(expected.getUserId(), actual.getUserId());
        Assert.assertEquals(expected.getBalance().getBalance(), actual.getBalance().getBalance());
    }
}