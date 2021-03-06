package com.travelmanager.controller;

import com.google.gson.Gson;
import com.travelmanager.components.TripComponent;
import com.travelmanager.models.Traveller;
import com.travelmanager.models.Trip;
import com.travelmanager.services.TripService;
import com.travelmanager.utils.HateoasResponse;
import com.travelmanager.utils.HateoasUtil;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin(origins = "http://travel-manager-final.herokuapp.com", maxAge = 3600)
@RestController
@RequestMapping("/trips")
public class TripController extends HateoasController<Trip, Integer> {

    private Gson gson = new Gson();

    @Setter
    private TripService service;

    @Setter
    private TripComponent component;

    public TripController(TripService _service) {
        super(_service);
        service = _service;
    }

    @PostMapping("{id}/join")
    public HttpEntity<HateoasResponse> join(@PathVariable int id, @RequestBody Traveller traveller){
        Trip trip = service.read(id);
        component.addTraveller(trip, traveller);
        return HateoasUtil.build(trip);
    }

    @DeleteMapping("{id}/leave")
    public HttpEntity<HateoasResponse> leave(@PathVariable int id, @RequestBody Traveller traveller){
        Trip trip = service.read(id);
        component.removeTraveller(trip, traveller);
        return HateoasUtil.build(trip);
    }


    @GetMapping(value = "/byDate")
    public ResponseEntity<String> getAllByDateEndAndDateStart(@RequestParam(name = "dateStart", required = true) String dateStart, @RequestParam(name = "dateEnd", required = true) String dateEnd, @RequestParam(name = "isPublic", required = true) Boolean isPublic){
        Date start;
        Date end;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        try{
            start = new Date(simpleDateFormat.parse(dateStart).getTime());
            end = new Date(simpleDateFormat.parse(dateEnd).getTime());
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<Trip> result = service.getAllByDateEndAndDateStart(start,end,isPublic);
        return new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
    }

    @GetMapping(value = "/byLongAndLat")
    public ResponseEntity<String> getAllByLatAndLong(@RequestParam(name = "lat", required = true) String latitude, @RequestParam(name = "long", required = true) String longitude, @RequestParam(name = "range", required = false) String range){
        Float floatLatitude;
        Float floarLongitude;
        Float floatRange = null;
        try{
            floatLatitude = Float.parseFloat(latitude);
            floarLongitude = Float.parseFloat(longitude);
            if(range != null){
                floatRange = Float.parseFloat(range);
            }
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<Trip> result = service.getAllByLatAndLong(floatLatitude,floarLongitude,floatRange);
        return new ResponseEntity<>(gson.toJson(result), HttpStatus.OK);
    }

    @Override
    public Class<? extends HateoasController<Trip, Integer>> getClazz() {
        return this.getClass();
    }

    @Override
    public Class<? extends ResourceSupport> getType() {
        return Trip.class;
    }

}
