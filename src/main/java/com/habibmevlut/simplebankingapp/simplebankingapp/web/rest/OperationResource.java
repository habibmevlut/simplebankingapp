package com.habibmevlut.simplebankingapp.simplebankingapp.web.rest;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BillPayment;
import com.habibmevlut.simplebankingapp.simplebankingapp.domain.Operation;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.BillPaymentService;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.OperationService;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.dto.BillPaymentInputDTO;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.dto.OperationInputDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ApiOperation(value = "/api/operation", tags = "Operation Web Rest")
@RestController
@RequestMapping("/api")
public class OperationResource {
    @Autowired
    OperationService operationService;
    @Autowired
    BillPaymentService billPaymentService;

    @ApiOperation(value = "Fetch All Operations", response = Iterable.class)
    @GetMapping("/operation")
    public List<Operation> getAllOperation() {
        return operationService.getAll();
    }

    @ApiOperation(value = "Fetch Operation By Id", response = Operation.class)
    @GetMapping("/operation/{id}")
    public Optional<Operation> getOperationById(@PathVariable Long id) {
        return operationService.getById(id);
    }

    @ApiOperation(value = "Fetch Operation By Account Id", response = Operation.class)
    @GetMapping("/operation-account/{id}")
    public List<Operation> getOperationByAccountId(@PathVariable Long id) {
        return operationService.getByAccountId(id);
    }

    @ApiOperation(value = "Deposit Operation", response = Operation.class)
    @PostMapping("/operation/deposit")
    public Operation deposit(@RequestBody OperationInputDTO operationInputDTO) {
        return operationService.depositOperation(operationInputDTO);
    }

    @ApiOperation(value = "Withdraw Operation", response = Operation.class)
    @PostMapping("/operation/withdraw")
    public Operation withDraw(@RequestBody OperationInputDTO operationInputDTO) {
        return operationService.withDrawOperation(operationInputDTO);
    }

    @ApiOperation(value = "Bill Payment Operation", response = BillPayment.class)
    @PostMapping("/operation-bill-paymnet")
    public BillPayment pay(@RequestBody BillPaymentInputDTO billPaymentInputDTO) {
        return billPaymentService.save(billPaymentInputDTO);
    }

    @ApiOperation(value = "Get All Bill Payment Operations", response = BillPayment.class)
    @GetMapping("/operation-bill-payment")
    public List<BillPayment> getAllBillPayment() {
        return billPaymentService.getAll();
    }

    @ApiOperation(value = "Get Bill Payment Operation By Id", response = BillPayment.class)
    @GetMapping("/operation-bill-payment/{id}")
    public Optional<BillPayment> getAllBillPaymentById(@PathVariable Long id) {
        return billPaymentService.getById(id);
    }

}
