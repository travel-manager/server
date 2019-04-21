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

import java.text.SimpleDateFormat;
import java.util.Date;
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
        Date start;
        Date end;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        try{
            start = simpleDateFormat.parse(dateStart);
            end = simpleDateFormat.parse(dateEnd);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<Trip> result = service.getAllByDateEndAndDateStart(start,end,isPublic);
        return new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<String> getAllByLatAndLong(@RequestParam(name = "lat", required = true) String latitude, @RequestParam(name = "long", required = true) String longitude, @RequestParam(name = "range", required = true) String range){
        long longLatitude;
        long longLongitude;
        long longRange;
        try{
             longLatitude = Long.parseLong(latitude);
             longLongitude = Long.parseLong(latitude);
             longRange = Long.parseLong(latitude);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<Trip> result = service.getAllByLatAndLong(longLatitude,longLongitude,longRange);
        return new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
    }

    @Override
    public Class<? extends HateoasController<Trip, Integer>> getClazz() {
        return this.getClass();
    }
}
