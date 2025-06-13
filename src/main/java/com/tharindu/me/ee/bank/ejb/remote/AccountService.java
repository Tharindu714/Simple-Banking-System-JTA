package com.tharindu.me.ee.bank.ejb.remote;

public interface AccountService {
void creditToAccount(String accountNumber, double amount) throws Exception;
void debitFromAccount(String accountNumber, double amount) throws Exception;
}
