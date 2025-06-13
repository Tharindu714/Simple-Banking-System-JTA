package com.tharindu.me.ee.bank.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@NamedQueries({
        @NamedQuery(name = "Account.findByAccountNo", query = "SELECT a FROM Account a WHERE a.accountNo=:accountNo"),
})
@Cacheable(value = false)
@org.hibernate.annotations.Cache(region = "account-cache",usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String accountNo;
    private double balance;

    @ManyToOne (cascade = CascadeType.ALL)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
