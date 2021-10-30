package com.habibmevlut.simplebankingapp.simplebankingapp.web.rest;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BillPayment;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.Operation;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.BillPaymentService;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.OperationService;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.dto.BillPaymentInputDTO;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.dto.OperationInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OperationResource {
    @Autowired
    OperationService operationService;
    @Autowired
    BillPaymentService billPaymentService;

    @GetMapping("/operation")
    public List<Operation> getAllOperation() {
        return operationService.getAll();
    }

    @GetMapping("/operation/{id}")
    public Optional<Operation> getOperationById(@PathVariable Long id) {
        return operationService.getById(id);
    }

    @GetMapping("/operation-account/{id}")
    public List<Operation> getOperationByAccountId(@PathVariable Long id) {
        return operationService.getByAccountId(id);
    }


    @PostMapping("/operation/deposit")
    public Operation deposit(@RequestBody OperationInputDTO operationInputDTO) {
        return operationService.depositOperation(operationInputDTO);
    }

    @PostMapping("/operation/withdraw")
    public Operation withDraw(@RequestBody OperationInputDTO operationInputDTO) {
        return operationService.withDrawOperation(operationInputDTO);
    }

    @PostMapping("/operation-bill-paymnet")
    public BillPayment pay(@RequestBody BillPaymentInputDTO billPaymentInputDTO) {
        return billPaymentService.save(billPaymentInputDTO);
    }

}
