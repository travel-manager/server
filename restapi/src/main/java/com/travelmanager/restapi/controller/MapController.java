package com.travelmanager.restapi.controller;

import interfaces.logic.handlers.IMarkerHandler;
import interfaces.rest.IMapController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/map")
public class MapController implements IMapController {

    IMarkerHandler logic;

    @PostMapping("/")
    public ResponseEntity create(String jsonString) {
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
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
