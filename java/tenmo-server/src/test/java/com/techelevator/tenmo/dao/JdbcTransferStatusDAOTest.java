package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.model.TransferStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class JdbcTransferStatusDAOTest extends TenmoDaoTests {
    private TransferStatusDAO sut;
    private TransferStatus testStatus;

    @Before
    public void setup() {
        sut = new JdbcTransferStatusDAO(dataSource);
        testStatus= new TransferStatus(1, "Approved");
    }


    @Test
    public void getTransferStatusByDesc_returns_correct_transfer_status() {
        TransferStatus actual = sut.getTransferStatusByDesc("Approved");
        TransferStatus expected = testStatus;

        assertTransferStatusesMatch(expected, actual);
    }

    @Test
    public void getTransferStatusById_returns_correct_transfer_status() {
        TransferStatus actual = sut.getTransferStatusById(1);
        TransferStatus expected = testStatus;

        assertTransferStatusesMatch(expected, actual);
    }

    private void assertTransferStatusesMatch(TransferStatus expected, TransferStatus actual) {
        Assert.assertEquals(expected.getTransferStatusDesc(), actual.getTransferStatusDesc());
        Assert.assertEquals(expected.getTransferStatusId(), actual.getTransferStatusId());
    }
}