package com.travelmanager.restapi.controller;

import handlers.AccountHandler;
import interfaces.logic.IAccountHandler;
import interfaces.rest.IAccountController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/traveller")
public class TravellerController{

    IAccountHandler logic = new AccountHandler();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestParam(name = "username",required = true) String username, @RequestParam(name = "password", required = true) String password){
        logic.login(username,password);
        return new ResponseEntity<String>(username + " : " + password, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestParam(name = "firstName", required = true) String firstName, @RequestParam(name = "lastName", required = true) String lastName, @RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password){
        logic.register(firstName,lastName,username,password);
        return new ResponseEntity<String>("First name: " + firstName + ", last name: " + lastName + ", username: " + username + ", password : " + password, HttpStatus.OK);
    }
}
