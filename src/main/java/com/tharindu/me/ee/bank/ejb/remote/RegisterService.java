package com.tharindu.me.ee.bank.ejb.remote;

import jakarta.ejb.Local;

@Local
public interface RegisterService{
    void registerUser(String name, String email, String password);
}
