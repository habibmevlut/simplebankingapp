package com.habibmevlut.simplebankingapp.simplebankingapp.service.dto;

public class BillPaymentInputDTO extends OperationInputDTO {

    private String payee;
    private Long operationId;
    private Long bankAccountId;

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    @Override
    public Long getBankAccountId() {
        return bankAccountId;
    }

    @Override
    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }
}
