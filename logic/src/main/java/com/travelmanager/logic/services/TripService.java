package com.travelmanager.logic.services;

import com.travelmanager.dal.repositories.ITripRepository;
import com.travelmanager.domain.interfaces.logic.services.ITripService;
import com.travelmanager.domain.models.Trip;
import com.travelmanager.hateoas.abstracts.HateaosService;

public class TripService extends HateaosService<Trip, Integer> implements ITripService {

    private ITripRepository repository;

    public TripService(ITripRepository _repo) {
        super(_repo);
        repository = _repo;
    }

    @Override
    public Class<? extends HateaosService<Trip, Integer>> getClazz() {
        return null;
    }
}
