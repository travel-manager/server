package com.travelmanager.controller;

import com.google.gson.Gson;
import com.travelmanager.annotations.LoginRequired;
import com.travelmanager.models.Marker;
import com.travelmanager.services.MarkerService;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/markers")
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

    @Override
    public Class<? extends ResourceSupport> getType() {
        return Marker.class;
    }

    @RequestMapping(value = "/byTrip", method = RequestMethod.GET)
    public ResponseEntity<String> getAllMarkersByTripId(@RequestParam(name = "tripid") int tripId){
        List<Marker> markers = service.getAllMarkersByTripId(tripId);
        String json = gson.toJson(markers);
        return new ResponseEntity<String>(json, HttpStatus.OK);
    }

    @LoginRequired
    @RequestMapping(value = "/byTrip", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteAllMarkersByTripId(@RequestParam(name = "tripid") int tripId){
        if (service.deleteAllMarkersByTripId(tripId)){
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }else {
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
