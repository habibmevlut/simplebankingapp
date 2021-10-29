package com.habibmevlut.simplebankingapp.simplebankingapp.service;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BankAccount;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.DepositOperation;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.Operation;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.WithdrawalOperation;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.enumeration.OperationTypeEnum;
import com.habibmevlut.simplebankingapp.simplebankingapp.repository.BankAccountRepository;
import com.habibmevlut.simplebankingapp.simplebankingapp.repository.OperationRepository;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.dto.OperationInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;


@Service
@Transactional
public class OperationService {
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    BankAccountRepository bankAccountRepository;

    public Operation withDrawOperation(OperationInputDTO operationInputDTO) {
        BankAccount account = bankAccountRepository.findById(operationInputDTO.getBankAccountId()).get();
        WithdrawalOperation withdrawalOperation = new WithdrawalOperation();
        withdrawalOperation.setAmount(operationInputDTO.getAmount());
        withdrawalOperation.setBankAccount(account);
        withdrawalOperation.setDate(LocalDateTime.now());
        withdrawalOperation.setOperationType(OperationTypeEnum.WITHDRAW);
        account.setBalance(withdrawalOperation.operate(operationInputDTO.getAmount()));
        bankAccountRepository.save(account);
        return operationRepository.save(withdrawalOperation);
    }

    public Operation depositOperation(OperationInputDTO operationInputDTO) {
        BankAccount account = bankAccountRepository.findById(operationInputDTO.getBankAccountId()).get();
        DepositOperation depositOperation = new DepositOperation();
        depositOperation.setAmount(operationInputDTO.getAmount());
        depositOperation.setBankAccount(account);
        depositOperation.setDate(LocalDateTime.now());
        depositOperation.setOperationType(OperationTypeEnum.DEPOSIT);
        account.setBalance(depositOperation.operate(operationInputDTO.getAmount()));
        bankAccountRepository.save(account);
        return operationRepository.save(depositOperation);
    }
}
