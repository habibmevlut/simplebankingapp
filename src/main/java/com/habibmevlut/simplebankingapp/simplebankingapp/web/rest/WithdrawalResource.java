package com.habibmevlut.simplebankingapp.simplebankingapp.web.rest;

import com.habibmevlut.simplebankingapp.simplebankingapp.domain.Operation;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.OperationService;
import com.habibmevlut.simplebankingapp.simplebankingapp.service.dto.OperationInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WithdrawalResource {
    @Autowired
    OperationService operationService;

    @PostMapping("/operation/withdraw")
    public Operation save(@RequestBody OperationInputDTO operationInputDTO) {
        return operationService.saveWithDraw(operationInputDTO);
    }
}
