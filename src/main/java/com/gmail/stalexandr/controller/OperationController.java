package com.gmail.stalexandr.controller;

import com.gmail.stalexandr.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public String getOperationPage() {
        return "operations";
    }

    @PostMapping
    public void operationReplanishment(){

    }
}
