package com.tharindu.me.ee.bank.ejb.Test;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.transaction.TransactionSynchronizationRegistry;

@Stateless
public class NewBeanB {
    @Resource
    private TransactionSynchronizationRegistry tsr;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void doActionB(){
        // Implementation of action B
        System.out.println("Action B executed in NewBeanB");
        System.out.println(tsr.getTransactionKey()); //txId=6 [com.sun.ejb.containers.ContainerSynchronization@3dcef64e]

        String name = (String) tsr.getResource("txId");
        System.out.println("Transaction ID from registry: " + name); // Should print 7
    }
}
