package com.habibmevlut.simplebankingapp.simplebankingapp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class DepositOperation extends Operation {

    @Override
    public double operate(Double amount) {
        return this.getBankAccount().getBalance() + amount;
    }
}
