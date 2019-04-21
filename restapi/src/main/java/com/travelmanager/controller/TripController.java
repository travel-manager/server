package com.travelmanager.controller;

import com.google.gson.Gson;
import com.travelmanager.models.Traveller;
import com.travelmanager.models.Trip;
import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.services.TripService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController extends HateoasController<Trip, Integer> {

    private Gson gson = new Gson();

    @Setter
    TripService service;

    @Autowired
    public TripController(TripService _service) {
        super(_service);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<String> getAllByDateEndAndDateStart(@RequestParam(name = "dateStart", required = true) String dateStart, @RequestParam(name = "dateEnd", required = true) String dateEnd, @RequestParam(name = "isPublic", required = true) Boolean isPublic){
        List<Trip> result = service.getAllByDateEndAndDateStart(dateStart,dateEnd,isPublic);
        return new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
    }

    @Override
    public Class<? extends HateoasController<Trip, Integer>> getClazz() {
        return this.getClass();
    }
}
