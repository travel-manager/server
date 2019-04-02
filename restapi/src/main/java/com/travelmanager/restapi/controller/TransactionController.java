package com.travelmanager.restapi.controller;

import com.travelmanager.domain.enums.Gender;
import com.travelmanager.domain.models.Transaction;
import com.travelmanager.domain.models.Traveller;
import com.travelmanager.logic.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController  {

    TransactionService logic = new TransactionService();

    @PostMapping("/")
    public ResponseEntity create(String jsonString) {
        return null;
    }

    @GetMapping("/test")
    public List<Transaction> read(String jsonString) {
        Traveller tr = new Traveller(1,"","","","","","",0.1, Gender.MALE, null,null,null);
        return logic.calculatePayRequestForTraveller(tr);
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
