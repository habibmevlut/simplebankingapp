package com.habibmevlut.simplebankingapp.simplebankingapp.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bank_account")
public class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "owner")
    private String owner;

    @NotNull
    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "balance")
    private Double balance;

//    @OneToMany(mappedBy = "bankAccount")
//    private List<Operation> operation;

    public BankAccount(Long id, String owner, String accountNumber, Double balance, List<Operation> operation) {
        this.id = id;
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
//        this.operation = operation;
    }

    public BankAccount() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

//    public List<Operation> getOperation() {
//        return operation;
//    }
//
//    public void setOperation(List<Operation> operation) {
//        this.operation = operation;
//    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }


}
