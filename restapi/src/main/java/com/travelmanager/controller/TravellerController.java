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
    public ResponseEntity<String> login(@RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password){
        Traveller result = service.login(username,password);
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
    public ResponseEntity<String> register(@RequestParam(name = "firstName", required = true) String firstName, @RequestParam(name = "lastName", required = true) String lastName, @RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password, @RequestParam(name = "country", required = true) String country){
        Traveller traveller = new Traveller();
        traveller.setUsername(username);
        traveller.setFirstname(firstName);
        traveller.setLastname(lastName);
        traveller.setCountry(country);

        Traveller result = service.register(traveller, password);
        if(result != null){
            if(result.getUsername() == null){
                return new ResponseEntity<String>("Username is Occupied", HttpStatus.METHOD_NOT_ALLOWED);
            }
            return new ResponseEntity<String>(gson.toJson(result), HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Woops something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<String> test(){
        Traveller traveller = new Traveller();
        traveller.setUsername("aefegsg");
        traveller.setFirstname("");
        traveller.setLastname("");
        traveller.setCountry("");
        traveller.setBio("");
        return new ResponseEntity<String>(service.test(traveller).toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public Class<? extends HateoasController<Traveller, Integer>> getClazz() {
        return this.getClass();
    }
}
