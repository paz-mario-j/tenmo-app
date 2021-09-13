package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.model.Transfer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JdbcTransferDAOTest extends TenmoDaoTests {

    private JdbcTransferDAO sut;
    private Transfer testTransfer;
    private Transfer testTransfer2;

    @Before
    public void setup() {
        sut = new JdbcTransferDAO(new JdbcTemplate(dataSource));
        testTransfer = new Transfer(4001, 1, 1, 2001, 2002, new BigDecimal("300.00"));
        testTransfer2 = new Transfer(4002, 1, 1, 2002, 2001, new BigDecimal("50.00"));
    }

    @Test
    public void createTransfer_creates_new_transfer_in_database() {
        Transfer transferToCreate = new Transfer(4003, 1, 1, 2002, 2001, new BigDecimal("100.00"));
        sut.createTransfer(transferToCreate);

        Transfer actual = sut.getTransferByTransferId(4003);
        Transfer expected = transferToCreate;

        assertTransfersMatch(expected, actual);
    }

    @Test
    public void getTransfersByUserId_returns_correct_number_of_transfers() {
        List<Transfer> actualList = sut.getTransfersByUserId(1001);

        Assert.assertEquals(actualList.size(), 2);
        assertTransfersMatch(testTransfer, actualList.get(0));
        assertTransfersMatch(testTransfer2, actualList.get(1));
    }

    @Test
    public void getTransferByTransferId_returns_correct_transfer() {
        Transfer actual = sut.getTransferByTransferId(4001);
        Transfer expected = testTransfer;

        assertTransfersMatch(expected, actual);
    }

    @Test
    public void getAllTransfers_returns_correct_number_of_transfers() {
        List<Transfer> transferList = sut.getAllTransfers();

        Assert.assertEquals(2, transferList.size());
        assertTransfersMatch(testTransfer, transferList.get(0));
        assertTransfersMatch(testTransfer2, transferList.get(1));
    }

    private void assertTransfersMatch(Transfer expected, Transfer actual) {
        Assert.assertEquals(expected.getTransferId(), actual.getTransferId());
        Assert.assertEquals(expected.getTransferStatusId(), actual.getTransferStatusId());
        Assert.assertEquals(expected.getTransferTypeId(), actual.getTransferTypeId());
        Assert.assertEquals(expected.getAccountTo(), actual.getAccountTo());
        Assert.assertEquals(expected.getAmount(), actual.getAmount());
    }
}