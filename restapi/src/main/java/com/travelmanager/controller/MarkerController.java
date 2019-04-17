package com.travelmanager.controller;

import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Marker;
import com.travelmanager.services.MarkerService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Markers")
public class MarkerController extends HateoasController<Marker, Integer> {

    @Setter
    MarkerService service;

    @Autowired
    public MarkerController(MarkerService _service) {
        super(_service);
    }

    @Override
    public Class<? extends HateoasController<Marker, Integer>> getClazz() {
        return this.getClass();
    }
}
