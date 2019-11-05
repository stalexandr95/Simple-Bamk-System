package com.gmail.stalexandr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class OperationRepl extends Operation {

    @Column
    private Date date;

    @Column
    private Double amount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public OperationRepl() {
    }
}
