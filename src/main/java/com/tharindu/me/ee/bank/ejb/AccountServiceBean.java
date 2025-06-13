package com.tharindu.me.ee.bank.ejb;

import com.tharindu.me.ee.bank.ejb.remote.AccountService;
import com.tharindu.me.ee.bank.entity.Account;
import jakarta.ejb.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Stateless
//@TransactionManagement(TransactionManagementType.BEAN)
public class AccountServiceBean implements AccountService {
    /**
     * This method credits the specified amount to the account with the given account number.
     *
     * @param accountNumber The account number to credit.
     * @param amount The amount to credit to the account.
     * @throws Exception If an error occurs during the credit operation.
     */

    @PersistenceContext
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void creditToAccount(String accountNumber, double amount) throws Exception {
        try {
            Account account = em.createNamedQuery("Account.findByAccountNo", Account.class)
                    .setParameter("accountNo", accountNumber)
                    .getSingleResult();
            if (amount > 0) {
                account.setBalance(account.getBalance() + amount);
            }
            em.merge(account);
        } catch (NoResultException e) {
            throw new Exception("Account not found: " + accountNumber);
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void debitFromAccount(String accountNumber, double amount) throws Exception {
        try {
            Account account = em.createNamedQuery("Account.findByAccountNo", Account.class)
                    .setParameter("accountNo", accountNumber)
                    .getSingleResult();
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                em.merge(account);
            } else {
                throw new Exception("Insufficient balance in account: " + accountNumber);
            }
        } catch (Exception e) {
            throw new Exception("Account not found: " + accountNumber);
        }
    }
}
