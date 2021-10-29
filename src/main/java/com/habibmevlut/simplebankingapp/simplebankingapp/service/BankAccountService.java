package com.habibmevlut.simplebankingapp.simplebankingapp.service;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BankAccount;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.Operation;
import com.habibmevlut.simplebankingapp.simplebankingapp.repository.BankAccountRepository;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.dto.BankAccountInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    public BankAccount save(BankAccountInputDTO bankAccountInputDTO) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setOwner(bankAccountInputDTO.getOwner());
        bankAccount.setAccountNumber(bankAccountInputDTO.getAccountNumber());
        bankAccount.setBalance(bankAccountInputDTO.getBalance());

        return bankAccountRepository.save(bankAccount);

    }

    public List<BankAccount> getAll() {
        return bankAccountRepository.findAll();
    }

    public Optional<BankAccount> getById(Long id) {
        Optional<BankAccount> result = bankAccountRepository.findById(id);
        return result;
    }

    public void post(Operation operation) {
        BankAccount bankAccount = bankAccountRepository.findById(operation.getBankAccount().getId()).get();
        double newBalance = operation.operate(operation.getAmount());
        bankAccount.setBalance(newBalance);

        bankAccountRepository.save(bankAccount);
    }
}
