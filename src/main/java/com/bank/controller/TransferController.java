package com.bank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}