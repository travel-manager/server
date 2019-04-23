package com.travelmanager.controller;

import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Marker;
import com.travelmanager.services.MarkerService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marker")
public class MarkerController extends HateoasController<Marker, Integer> {

    Gson gson = new Gson();

    @Setter
    private MarkerService service;

    public MarkerController(MarkerService _service) {
        super(_service);
        service = _service;
    }

    @Override
    public Class<? extends HateoasController<Marker, Integer>> getClazz() {
        return this.getClass();
    }

    @RequestMapping(value = "/getallbytrip", method = RequestMethod.GET)
    public ResponseEntity<String> getAllMarkersByTripId(@RequestParam(name = "tripid") int tripId){
        List<Marker> markers = service.getAllMarkersByTripId(tripId);
        String json = gson.toJson(markers);
        return new ResponseEntity<String>(json, HttpStatus.OK);
    }

    @RequestMapping(value = "/deletebytrip", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteAllMarkersByTripId(@RequestParam(name = "tripid") int tripId){
        if (service.deleteAllMarkersByTripId(tripId)){
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }else {
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
