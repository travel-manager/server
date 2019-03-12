package com.travelmanager.restapi.controller;

import handlers.TravellerHandler;
import interfaces.logic.handlers.ITravellerHandler;
import interfaces.rest.ITravellerController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traveller")
public class TravellerController implements ITravellerController {

    ITravellerHandler logic = new TravellerHandler();

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password){
        logic.login(username,password);
        return new ResponseEntity<String>(username + " : " + password, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestParam(name = "firstName", required = true) String firstName, @RequestParam(name = "lastName", required = true) String lastName, @RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password){
        logic.register(firstName,lastName,username,password);
        return new ResponseEntity<String>("First name: " + firstName + ", last name: " + lastName + ", username: " + username + ", password : " + password, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity create(String jsonString) {
        return null;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity read(String jsonString) {
        return null;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity update(String jsonString) {
        return null;
    }

    @Override
    @DeleteMapping("/")
    public ResponseEntity delete(String jsonString) {
        return null;
    }
}
