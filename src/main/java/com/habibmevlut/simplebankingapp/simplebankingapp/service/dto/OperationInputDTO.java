package com.habibmevlut.simplebankingapp.simplebankingapp.service.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationInputDTO that = (OperationInputDTO) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(bankAccountId, that.bankAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, bankAccountId);
    }

    @Override
    public String toString() {
        return "OperationInputDTO{" +
                "amount=" + amount +
                ", bankAccountId=" + bankAccountId +
                '}';
    }
}
