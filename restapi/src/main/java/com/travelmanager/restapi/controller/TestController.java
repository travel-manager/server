package com.travelmanager.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/index")
    public ResponseEntity<String> index() {

       // System.out.println("Looking for index2");
        return new ResponseEntity<String>("index", HttpStatus.OK);
    }
}
