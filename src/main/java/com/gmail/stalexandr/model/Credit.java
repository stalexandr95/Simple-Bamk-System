package com.gmail.stalexandr.model;

import com.gmail.stalexandr.util.CurrUnit;

import javax.persistence.*;

public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double balance;

    @Column
    @Enumerated(EnumType.STRING)
    private CurrUnit currUnit; //валюта

    @Column(name = "limit", nullable = false)
    private Double limit; //лимит

    @Column(nullable = false)
    private Double rate; //ставка

    @Column(nullable = false)
    private Double accruedInterest; //начисленные проценты

    @Column
    private Boolean decision; //решение

    @OneToOne(mappedBy = "credit")
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrUnit getCurrUnit() {
        return currUnit;
    }

    public void setCurrUnit(CurrUnit currUnit) {
        this.currUnit = currUnit;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAccruedInterest() {
        return accruedInterest;
    }

    public void setAccruedInterest(Double accruedInterest) {
        this.accruedInterest = accruedInterest;
    }

    public Boolean getDecision() {
        return decision;
    }

    public void setDecision(Boolean decision) {
        this.decision = decision;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Credit() {
    }
}
