package com.travelmanager.restapi.controller;

import interfaces.logic.handlers.ITransactionHandler;
import interfaces.rest.ITransactionController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController implements ITransactionController {

    ITransactionHandler logic;

    @PostMapping("/")
    public ResponseEntity create(String jsonString) {
        return null;
    }

    @GetMapping("/")
    public ResponseEntity read(String jsonString) {
        return null;
    }

    @PutMapping("/")
    public ResponseEntity update(String jsonString) {
        return null;
    }

    @DeleteMapping("/")
    public ResponseEntity delete(String jsonString) {
        return null;
    }
}
