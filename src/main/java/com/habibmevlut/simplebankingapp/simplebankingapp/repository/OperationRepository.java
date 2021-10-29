package com.habibmevlut.simplebankingapp.simplebankingapp.repository;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
