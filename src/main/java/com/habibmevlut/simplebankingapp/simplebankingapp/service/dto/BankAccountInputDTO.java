package com.habibmevlut.simplebankingapp.simplebankingapp.service.dto;

public class BankAccountInputDTO {
    private String owner;
    private String accountNumber;
    private Double balance;
    private Long operationId;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    @Override
    public String toString() {
        return "BankAccountInput{" +
                "owner='" + owner + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", operationId=" + operationId +
                '}';
    }
}
