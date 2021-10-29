package com.habibmevlut.simplebankingapp.simplebankingapp.service.dto;

public class OperationInputDTO {
    private Double amount;
    private Long bankAccountId;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }
}
