package com.travelmanager.restapi.controller;

import interfaces.logic.handlers.ITransactionHandler;
import interfaces.rest.ITransactionController;
import handlers.TransactionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController implements ITransactionController {

    ITransactionHandler logic = new TransactionHandler();

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity create(String jsonString) {
        return null;
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity read(String jsonString) {
        return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity update(String jsonString) {
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity delete(String jsonString) {
        return null;
    }
}
