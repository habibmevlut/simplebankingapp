package com.habibmevlut.simplebankingapp.simplebankingapp.service.dto;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BankAccount;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.enumeration.OperationTypeEnum;

import java.time.LocalDateTime;
import java.util.Objects;

public class OperationResultDTO {
    private Long id;
    private LocalDateTime date;
    private Double amount;
    private OperationTypeEnum operationType;
    private BankAccount bankAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public OperationTypeEnum getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationTypeEnum operationType) {
        this.operationType = operationType;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationResultDTO that = (OperationResultDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(amount, that.amount) &&
                operationType == that.operationType &&
                Objects.equals(bankAccount, that.bankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, amount, operationType, bankAccount);
    }

    @Override
    public String toString() {
        return "OperationResultDTO{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", operationType=" + operationType +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
