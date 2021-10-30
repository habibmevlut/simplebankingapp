package com.habibmevlut.simplebankingapp.simplebankingapp.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "bill_payment_operation")
public class BillPayment {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    @NotNull
    private Boolean status;

    @Column(name = "payee")
    @NotNull
    private String payee;

    @NotNull
    @ManyToOne
    private Operation operation;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }
}
