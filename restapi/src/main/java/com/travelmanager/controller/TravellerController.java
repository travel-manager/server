package com.travelmanager.controller;

import com.google.gson.Gson;
import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.models.Traveller;
import com.travelmanager.services.TravellerService;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traveller")
public class TravellerController extends HateoasController<Traveller, Integer> {

    Gson gson = new Gson();

    @Setter
    private TravellerService service;

    public TravellerController(TravellerService _service) {
        super(_service);
        service = _service;
    }

//    @Override
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseEntity<String> login(@RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password){
//        service.login(username,password);
//        return new ResponseEntity<String>(username + " : " + password, HttpStatus.OK);
//    }
//
//    @Override
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public ResponseEntity<String> register(@RequestParam(name = "firstName", required = true) String firstName, @RequestParam(name = "lastName", required = true) String lastName, @RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password){
//        service.register(firstName,lastName,username,password);
//        return new ResponseEntity<String>("First name: " + firstName + ", last name: " + lastName + ", username: " + username + ", password : " + password, HttpStatus.OK);
//    }

    @GetMapping(value = "/get")
    public ResponseEntity<String> register(@RequestParam(name = "username", required = true) String username){
       Traveller result = service.getByUsername(username);
       return new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
    }


    @Override
    public Class<? extends HateoasController<Traveller, Integer>> getClazz() {
        return this.getClass();
    }
}
