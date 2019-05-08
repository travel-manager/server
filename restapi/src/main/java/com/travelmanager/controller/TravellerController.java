package com.travelmanager.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.models.Traveller;
import com.travelmanager.services.TravellerService;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/travellers")
public class TravellerController extends HateoasController<Traveller, Integer> {

    private Gson gson = new Gson();

    @Setter
    private TravellerService service;

    public TravellerController(TravellerService _service) {
        super(_service);
        service = _service;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<String> getByUsername(@RequestParam(name = "username", required = true) String username){
       Traveller result = service.getByUsername(username);
       return new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody ObjectNode node){
        Traveller result = service.login(node.get("username").asText(),node.get("password").asText());
        if(result != null){
            if(result.getUsername() != null){
                return new ResponseEntity<String>(gson.toJson(result), HttpStatus.OK);
            }else{
                return new ResponseEntity<String>("Username or Password is incorrect", HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<String>("Woops something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody ObjectNode node){
        Traveller traveller = new Traveller();
        traveller.setUsername(node.get("username").asText());
        traveller.setBio(node.get("bio").asText());
        traveller.setPicture(node.get("picture").asText());
        traveller.setFirstname(node.get("firstname").asText());
        traveller.setLastname(node.get("lastname").asText());
        traveller.setCountry(node.get("country").asText());

        Traveller result = service.register(traveller, node.get("password").asText());
        if(result != null){
            if(result.getUsername() == null){
                return new ResponseEntity<String>("Username is Occupied", HttpStatus.METHOD_NOT_ALLOWED);
            }
            return new ResponseEntity<String>(gson.toJson(result), HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Woops something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<Traveller> test(){
        Traveller traveller = new Traveller();
        traveller.setUsername("aefegsg");
        traveller.setFirstname("");
        traveller.setLastname("");
        traveller.setCountry("");
        traveller.setBio("");
        return new ResponseEntity<Traveller>(traveller, HttpStatus.OK);
    }

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    public ResponseEntity<Traveller> test1(){
        Traveller traveller = new Traveller();
        traveller.setUsername("posted");
        traveller.setFirstname("");
        traveller.setLastname("");
        traveller.setCountry("");
        traveller.setBio("");
        return new ResponseEntity<Traveller>(traveller, HttpStatus.OK);
    }

    @Override
    public Class<? extends HateoasController<Traveller, Integer>> getClazz() {
        return this.getClass();
    }
}
