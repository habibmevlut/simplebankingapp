package com.habibmevlut.simplebankingapp.simplebankingapp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class BillPaymentOperation extends Operation {
    @Override
    public double operate(Double amount) {
        return this.getBankAccount().getBalance() - amount;
    }
}
