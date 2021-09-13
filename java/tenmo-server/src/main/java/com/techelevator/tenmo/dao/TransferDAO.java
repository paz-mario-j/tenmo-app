package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDAO {

    void createTransfer(Transfer transfer);

    List<Transfer> getTransfersByUserId(int userId);

    Transfer getTransferByTransferId(int transferId);

    List<Transfer> getAllTransfers();
}
