package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.TransferStatus;
import com.techelevator.tenmo.model.TransferType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JdbcTransferTypeDaoTest extends TenmoDaoTests{
    private TransferTypeDao sut;
    private TransferType testTransferType;

    @Before
    public void setup() {
        sut = new JdbcTransferTypeDao(dataSource);
        testTransferType = new TransferType(1, "Request");
    }


    @Test
    public void getTransferTypeFromDescription_returns_correct_transfer_type() {
        TransferType actual = sut.getTransferTypeFromDescription("Request");

        assertTransferTypesEqual(testTransferType, actual);
    }

    @Test
    public void getTransferTypeFromId_returns_correct_transfer_type() {
        TransferType actual = sut.getTransferTypeFromId(1);

        assertTransferTypesEqual(testTransferType, actual);
    }

    private void assertTransferTypesEqual(TransferType expected, TransferType actual) {
        Assert.assertEquals(expected.getTransferTypeDescription(), actual.getTransferTypeDescription());
        Assert.assertEquals(expected.getTransferTypeId(), actual.getTransferTypeId());
    }
}