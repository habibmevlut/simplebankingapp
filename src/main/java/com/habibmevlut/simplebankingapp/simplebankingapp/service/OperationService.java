package com.habibmevlut.simplebankingapp.simplebankingapp.service;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BankAccount;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.DepositOperation;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.Operation;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.WithdrawOperation;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.enumeration.OperationTypeEnum;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.exception.InsufficientBalanceException;
import com.habibmevlut.simplebankingapp.simplebankingapp.repository.BankAccountRepository;
import com.habibmevlut.simplebankingapp.simplebankingapp.repository.OperationRepository;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.dto.OperationInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class OperationService {
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    BankAccountRepository bankAccountRepository;

    public Operation withDrawOperation(OperationInputDTO operationInputDTO) {
        BankAccount account = bankAccountRepository.findById(operationInputDTO.getBankAccountId()).get();
        WithdrawOperation withdrawOperation = new WithdrawOperation();
        withdrawOperation.setAmount(operationInputDTO.getAmount());
        withdrawOperation.setBankAccount(account);
        withdrawOperation.setDate(LocalDateTime.now());
        withdrawOperation.setOperationType(OperationTypeEnum.WITHDRAW);
        try {
            if (account.getBalance() > operationInputDTO.getAmount()) {
                account.setBalance(withdrawOperation.operate(operationInputDTO.getAmount()));
            } else {
                throw new InsufficientBalanceException();
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        bankAccountRepository.save(account);
        return operationRepository.save(withdrawOperation);
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

    public List<Operation> getAll() {
        return operationRepository.findAll();
    }

    public Optional<Operation> getById(Long id) {
        return operationRepository.findById(id);
    }

    public List<Operation> getByAccountId(Long id) {
        return operationRepository.findByBankAccountId(id);
    }
}
