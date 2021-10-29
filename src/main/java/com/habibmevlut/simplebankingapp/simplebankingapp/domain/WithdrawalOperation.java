package com.habibmevlut.simplebankingapp.simplebankingapp.domain;


import javax.persistence.Entity;

@Entity
public class WithdrawalOperation extends Operation {

    @Override
    public double operate(Double amount) {
        return this.getAmount() - amount;
    }
}
