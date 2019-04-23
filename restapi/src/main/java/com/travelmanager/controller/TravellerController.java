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

    @GetMapping(value = "/get")
    public ResponseEntity<String> getByUsername(@RequestParam(name = "username", required = true) String username){
       Traveller result = service.getByUsername(username);
       return new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
    }


    @Override
    public Class<? extends HateoasController<Traveller, Integer>> getClazz() {
        return this.getClass();
    }
}
