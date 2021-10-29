package com.habibmevlut.simplebankingapp.simplebankingapp.repository;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
