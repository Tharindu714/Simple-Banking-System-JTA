package com.tharindu.me.ee.bank.ejb;

import com.tharindu.me.ee.bank.ejb.remote.AccountService;
import com.tharindu.me.ee.bank.ejb.remote.TransferService;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.*;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TransferServiceBean implements TransferService {

    @EJB
    private AccountService accountService;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    @Override
//    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void transferAmount(String recipientAccount, String destinationAccount, double amount) throws Exception {
        try {
            utx.begin();
            accountService.debitFromAccount(recipientAccount, amount);
            accountService.creditToAccount(destinationAccount, amount);
            utx.commit();
        } catch (NotSupportedException e) {
            try {
                utx.rollback();
            } catch (SystemException ex) {
                throw new Exception("Transaction rollback failed: " + ex.getMessage(), ex);
            }
        } catch (SystemException e) {
            throw new Exception("Transaction rollback failed: " + e.getMessage(), e);
        } catch (HeuristicRollbackException e) {
            throw new Exception("Transaction rollback failed: " + e.getMessage(), e);
        } catch (HeuristicMixedException e) {
            throw new Exception("Transaction rollback failed: " + e.getMessage(), e);
        } catch (RollbackException e) {
            throw new Exception("Transaction rollback failed: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new Exception("Transaction rollback failed: " + e.getMessage(), e);
        }

        try {
            utx.begin();
            ///
            utx.commit();
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException ex) {
                throw new Exception("Transaction rollback failed: " + ex.getMessage(), ex);
            }
            throw new Exception("Transfer failed: " + e.getMessage(), e);
        }

    }
}
