package com.travelmanager.restapi.controller;

import com.travelmanager.domain.interfaces.rest.ITripController;
import com.travelmanager.domain.models.Trip;
import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.logic.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class TripController extends HateoasController<Trip, Integer> implements ITripController {

    TripService service;

    @Autowired
    public TripController(TripService _service) {
        super(_service);
        this.service = _service;
    }

    @Override
    public Class<? extends HateoasController<Trip, Integer>> getClazz() {
        return null;
    }
}
