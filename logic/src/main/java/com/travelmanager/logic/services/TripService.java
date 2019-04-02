package com.travelmanager.logic.services;

import com.travelmanager.dal.repositories.ITripRepository;
import com.travelmanager.domain.interfaces.logic.services.ITripService;
import com.travelmanager.domain.models.Trip;
import com.travelmanager.hateoas.abstracts.HateoasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService extends HateoasService<Trip, Integer> implements ITripService {

    private ITripRepository repository;

    @Autowired
    public TripService(ITripRepository _repo) {
        super(_repo);
        repository = _repo;
    }

    @Override
    public Class<? extends HateoasService<Trip, Integer>> getClazz() {
        return null;
    }
}
