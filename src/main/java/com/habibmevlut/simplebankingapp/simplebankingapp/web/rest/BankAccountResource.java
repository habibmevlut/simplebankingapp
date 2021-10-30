package com.habibmevlut.simplebankingapp.simplebankingapp.web.rest;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BankAccount;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.BankAccountService;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.dto.BankAccountInputDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ApiOperation(value = "/api/bank-account", tags = "Bank Account Web Rest")
@RestController
@RequestMapping("/api")
public class BankAccountResource {
    @Autowired
    BankAccountService bankAccountService;

    @ApiOperation(value = "Save Bank Account", response = BankAccount.class)
    @PostMapping("/bank-accounts")
    public BankAccount save(@RequestBody BankAccountInputDTO bankAccountInputDTO) {
        return bankAccountService.save(bankAccountInputDTO);
    }

    @ApiOperation(value = "Fetch All Bank Accounts", response = Iterable.class)
    @GetMapping("/bank-accounts")
    public List<BankAccount> getAllBankAccount() {
        return bankAccountService.getAll();
    }

    @ApiOperation(value = "Fetch Bank Account By Id", response = BankAccount.class)
    @GetMapping("/bank-accounts/{id}")
    public Optional<BankAccount> getBankAccountById(@PathVariable Long id) {
        return bankAccountService.getById(id);
    }
}
