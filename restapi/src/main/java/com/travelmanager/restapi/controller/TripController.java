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
