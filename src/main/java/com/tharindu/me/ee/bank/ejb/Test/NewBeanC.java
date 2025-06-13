package com.tharindu.me.ee.bank.ejb.Test;

import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class NewBeanC {
    @EJB
    private NewBeanD beanD;

    @Inject
    private UserTransaction ut;

    public void doActionC(){
        // Implementation of action C
        try {
            ut.begin(); // Begin transaction
            System.out.println("Action C executed in NewBeanC");
            System.out.println(ut);
            doWorkC();
            beanD.doActionD();
            ut.commit();
        } catch (Exception e) {
           throw new EJBException("Transaction failed in NewBeanC", e);
        }
    }

    public void doWorkC() {
        // Additional work can be done here
        System.out.println("Work C executed in NewBeanC with : " + ut);
    }
}
