package com.habibmevlut.simplebankingapp.simplebankingapp.service.dto;

public class BankAccountResultDTO {
    private Long id;
    private String owner;
    private String accountNumber;
    private Double balance;
    private Long operationId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "BankAccountResult{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", operationId=" + operationId +
                '}';
    }
}
