package com.travelmanager.restapi.controller;

import handlers.TripHandler;
import interfaces.logic.handlers.ITripHandler;
import interfaces.rest.ITripController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class TripController implements ITripController {

    ITripHandler logic  = new TripHandler();

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
