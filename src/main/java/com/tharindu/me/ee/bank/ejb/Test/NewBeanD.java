package com.tharindu.me.ee.bank.ejb.Test;

import jakarta.annotation.Resource;
import jakarta.ejb.*;
import jakarta.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class NewBeanD {

    @Resource
    private UserTransaction ut;

    public void doActionD(){
        // Implementation of action B
        System.out.println("Action D executed in NewBeanD");
        System.out.println(ut);
    }
}
