package com.gmail.stalexandr.model;

import com.gmail.stalexandr.util.CurrUnit;

import javax.persistence.*;
import java.util.Date;

public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double balance;

    @Column
    @Enumerated(EnumType.STRING)
    private CurrUnit currUnit;

    @Column(nullable = false)
    private Double rate;

    @Column(nullable = false)
    private Date term;

    @OneToOne(mappedBy = "deposit")
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public CurrUnit getCurrUnit() {
        return currUnit;
    }

    public void setCurrUnit(CurrUnit currUnit) {
        this.currUnit = currUnit;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getTerm() {
        return term;
    }

    public void setTerm(Date term) {
        this.term = term;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Deposit() {
    }
}
