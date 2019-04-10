package com.travelmanager.controller;

import com.travelmanager.domain.interfaces.rest.ITripController;
import com.travelmanager.models.Trip;
import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.services.TripService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class TripController extends HateoasController<Trip, Integer> implements ITripController {

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
}
