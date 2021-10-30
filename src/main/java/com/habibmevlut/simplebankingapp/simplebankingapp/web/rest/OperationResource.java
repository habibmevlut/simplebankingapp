package com.habibmevlut.simplebankingapp.simplebankingapp.web.rest;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.Operation;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.OperationService;
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

    @GetMapping("/operation")
    public List<Operation> getAllOperation() {
        return operationService.getAll();
    }

    @GetMapping("/operation/{id}")
    public Optional<Operation> getOperationById(@PathVariable Long id) {
        return operationService.getById(id);
    }

    @PostMapping("/operation/deposit")
    public Operation deposit(@RequestBody OperationInputDTO operationInputDTO) {
        return operationService.depositOperation(operationInputDTO);
    }

    @PostMapping("/operation/withdraw")
    public Operation withDraw(@RequestBody OperationInputDTO operationInputDTO) {
        return operationService.withDrawOperation(operationInputDTO);
    }
}
