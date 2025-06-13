package com.tharindu.me.ee.bank.ejb.Test;

import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.transaction.TransactionSynchronizationRegistry;

@Stateless
public class NewBeanA {
    @EJB
    private NewBeanB beanB;

    @Resource
    private TransactionSynchronizationRegistry tsr;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void doActionA(){
        // Implementation of action A
        System.out.println("Action A executed in NewBeanA");

        tsr.putResource("txId", "txID : 7"); // Storing transaction ID in the registry

        //tsr.setRollbackOnly(); // Marking the transaction for rollback
        //boolean rollbackOnly = tsr.getRollbackOnly(); //Get RollbackOnly status
        //System.out.println("Is rollback only: " + rollbackOnly); // Should print true

        System.out.println(tsr.getTransactionKey());
        beanB.doActionB(); //txId=7
    }
}

