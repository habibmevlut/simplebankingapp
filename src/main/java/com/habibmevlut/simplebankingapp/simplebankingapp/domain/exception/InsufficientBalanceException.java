package com.habibmevlut.simplebankingapp.simplebankingapp.domain.exception;

public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException() {
        super();
        System.err.println("You do not have enough balance for this operation");
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
