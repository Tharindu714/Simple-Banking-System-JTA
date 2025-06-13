package com.tharindu.me.ee.bank.ejb;

import com.tharindu.me.ee.bank.ejb.remote.LoginService;
import com.tharindu.me.ee.bank.entity.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Stateless
public class LoginServiceBean implements LoginService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean login(String email, String password) {
        try {
            User user = em.createNamedQuery("User.findByEmailAndPassword", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();

            return true;
        } catch (NoResultException e) {
            // Log the exception (not shown here for brevity)
            return false;
        }

    }
}
