package com.travelmanager.logic.services;

import com.travelmanager.dal.repositories.ITripRepository;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Trip;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService extends HateoasService<Trip, Integer> {

    @Setter
    private ITripRepository repository;

    @Autowired
    public TripService(ITripRepository _repo) {
        super(_repo);
    }

    @Override
    public Class<? extends HateoasService<Trip, Integer>> getClazz() {
        return this.getClass();
    }
}
