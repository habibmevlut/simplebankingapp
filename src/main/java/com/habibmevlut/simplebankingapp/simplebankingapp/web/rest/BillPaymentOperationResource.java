package com.habibmevlut.simplebankingapp.simplebankingapp.web.rest;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.BillPayment;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.BillPaymentService;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.OperationService;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.dto.BillPaymentInputDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ApiOperation(value = "/api/operation/bill-payment", tags = "Bill Payment Operation Web Rest")
@RestController
@RequestMapping("/api")
public class BillPaymentOperationResource {
    @Autowired
    OperationService operationService;
    @Autowired
    BillPaymentService billPaymentService;

    @ApiOperation(value = "Save Bill Payment Operation", response = BillPayment.class)
    @PostMapping("/operation/bill-payment")
    public BillPayment pay(@RequestBody BillPaymentInputDTO billPaymentInputDTO) {
        return billPaymentService.save(billPaymentInputDTO);
    }

    @ApiOperation(value = "Get All Bill Payment Operations", response = BillPayment.class)
    @GetMapping("/operation/bill-payment")
    public List<BillPayment> getAllBillPayment() {
        return billPaymentService.getAll();
    }

    @ApiOperation(value = "Get Bill Payment Operation By Id", response = BillPayment.class)
    @GetMapping("/operation/bill-payment/{id}")
    public Optional<BillPayment> getAllBillPaymentById(@PathVariable Long id) {
        return billPaymentService.getById(id);
    }

}
