package com.habibmevlut.simplebankingapp.simplebankingapp.repository;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillPaymentRepository extends JpaRepository<BillPayment, Long> {
}
