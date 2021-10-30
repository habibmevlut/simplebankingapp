package com.habibmevlut.simplebankingapp.simplebankingapp.service;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BankAccount;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BillPayment;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.Operation;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BillPaymentOperation;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.enumeration.OperationTypeEnum;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.exception.InsufficientBalanceException;
import com.habibmevlut.simplebankingapp.simplebankingapp.repository.BankAccountRepository;
import com.habibmevlut.simplebankingapp.simplebankingapp.repository.BillPaymentRepository;
import com.habibmevlut.simplebankingapp.simplebankingapp.repository.OperationRepository;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.dto.BillPaymentInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class BillPaymentService {
    @Autowired
    BillPaymentRepository billPaymentRepository;
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    OperationRepository operationRepository;


    public BillPayment save(BillPaymentInputDTO billPaymentInputDTO) {
        BankAccount account = bankAccountRepository.findById(billPaymentInputDTO.getBankAccountId()).get();
        BillPayment billPayment = new BillPayment();
        BillPaymentOperation billPaymentOperation = new BillPaymentOperation();

        billPaymentOperation.setDate(LocalDateTime.now());
        billPaymentOperation.setOperationType(OperationTypeEnum.PAYMENT);
        billPaymentOperation.setAmount(billPaymentInputDTO.getAmount());
        billPaymentOperation.setBankAccount(account);

        Operation operationResult = operationRepository.save(billPaymentOperation);

        billPayment.setOperation(operationResult);
        billPayment.setPayee(billPaymentInputDTO.getPayee());
        try {
            if (account.getBalance() > billPaymentInputDTO.getAmount()) {
                account.setBalance(billPaymentOperation.operate(billPaymentInputDTO.getAmount()));
                billPayment.setStatus(true);
            } else {
                billPayment.setStatus(false);
                throw new InsufficientBalanceException();
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        bankAccountRepository.save(account);
        return billPaymentRepository.save(billPayment);
    }
}
