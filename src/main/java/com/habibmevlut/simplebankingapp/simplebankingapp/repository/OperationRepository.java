package com.habibmevlut.simplebankingapp.simplebankingapp.repository;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    List<Operation> findByBankAccountId(Long bankAccountId);
}
