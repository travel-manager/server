package com.travelmanager.controller;

import com.travelmanager.enums.Gender;
import com.travelmanager.models.Transaction;
import com.travelmanager.models.Traveller;
import com.travelmanager.services.TransactionService;
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
        Traveller tr = new Traveller("","","","","","",0.1, Gender.MALE, null,null,null);
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
