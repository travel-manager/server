package com.travelmanager.services;

import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Marker;
import com.travelmanager.repositories.IMarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MarkerService extends HateoasService<Marker, Integer> {

    private IMarkerRepository repo;

    @Autowired
    public MarkerService(IMarkerRepository _repo) {
        super(_repo);
    }

    @Override
    public Class<? extends HateoasService<Marker, Integer>> getClazz() {
        return this.getClass();
    }
}
