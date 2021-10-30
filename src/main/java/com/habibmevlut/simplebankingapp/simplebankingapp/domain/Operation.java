package com.habibmevlut.simplebankingapp.simplebankingapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.enumeration.OperationTypeEnum;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
//@Polymorphism(type = PolymorphismType.EXPLICIT)

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "operation_type_id", discriminatorType = DiscriminatorType.INTEGER)

@Table(name = "operation")
public abstract class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date")
    private LocalDateTime date;

    @NotNull
    @Column(name = "amount")
    private Double amount;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "operation_type_id", nullable = false, insertable = false, updatable = false)
    private OperationTypeEnum operationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BankAccount bankAccount;

    public abstract double operate(Double amount);

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
        Operation operation = (Operation) o;
        return Objects.equals(id, operation.id) &&
                Objects.equals(date, operation.date) &&
                Objects.equals(amount, operation.amount) &&
                operationType == operation.operationType &&
                Objects.equals(bankAccount, operation.bankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, amount, operationType, bankAccount);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", operationType=" + operationType +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
