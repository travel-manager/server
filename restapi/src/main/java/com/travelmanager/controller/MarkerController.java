package com.travelmanager.controller;

import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Marker;
import com.travelmanager.services.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;

public class MarkerController extends HateoasController<Marker, Integer> {

    MarkerService service;

    @Autowired
    public MarkerController(MarkerService _service) {
        super(_service);
        service = _service;
    }

    @Override
    public Class<? extends HateoasController<Marker, Integer>> getClazz() {
        return this.getClass();
    }
}
