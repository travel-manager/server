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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity create(String jsonString) {
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
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
