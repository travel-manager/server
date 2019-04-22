package com.travelmanager.controller;

import com.travelmanager.models.Trip;
import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.services.TripService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
public class TripController extends HateoasController<Trip, Integer> {

    @Setter
    TripService service;

    @Autowired
    public TripController(TripService _service) {
        super(_service);
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
