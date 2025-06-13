package com.tharindu.me.ee.bank.ejb;

import com.tharindu.me.ee.bank.ejb.remote.RegisterService;
import com.tharindu.me.ee.bank.entity.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class RegisterServiceBean implements RegisterService {

    @PersistenceContext(unitName = "jta-pu-bank")
    private EntityManager em;

    @Override
    public void registerUser(String name, String password, String email) {
        User user = new User(name, password, email);
        em.persist(user);

    }
}
