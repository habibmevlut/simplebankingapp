package com.habibmevlut.simplebankingapp.simplebankingapp.web.rest;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BankAccount;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.BankAccountService;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.dto.BankAccountInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BankAccountResource {
    @Autowired
    BankAccountService bankAccountService;

    @GetMapping("/bank-accounts")
    public List<BankAccount> getAllBankAccount() {
        return bankAccountService.getAll();
    }

    @GetMapping("/bank-accounts/{id}")
    public Optional<BankAccount> getBankAccountById(@PathVariable Long id) {
        return bankAccountService.getById(id);
    }

    @PostMapping("/bank-accounts")
    public BankAccount save(@RequestBody BankAccountInputDTO bankAccountInputDTO) {
        return bankAccountService.save(bankAccountInputDTO);
    }
}
