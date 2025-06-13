package com.tharindu.me.ee.bank.ejb.remote;

public interface TransferService {
    void transferAmount(String recipientAccount, String destinationAccount, double amount) throws Exception;
}
