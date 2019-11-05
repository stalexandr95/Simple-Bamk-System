package com.gmail.stalexandr.model;

import com.gmail.stalexandr.util.CurrUnit;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Double balance;

    @Column
    @Enumerated(EnumType.STRING)
    private CurrUnit currUnit;

    @Column(nullable = false)
    private Date validity;

    @OneToOne(mappedBy = "account")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userInfo_id")
    private UserInfo userInfo;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn (name="deposit_id")
    private Deposit deposit;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn (name="credit_id")
    private Credit credit;

    @OneToMany(mappedBy = "clientAccount")
    private List<Operation> operations = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public List<Operation> getOperations() {
        return operations;
    }

//    public void setOperations(List<Operation> operations) {
//        this.operations = operations;
//    }

    public void addOperation(Operation operation) {
        operations.add(operation);
        operation.setAccount(this);
    }

    public Account() {
    }
}
