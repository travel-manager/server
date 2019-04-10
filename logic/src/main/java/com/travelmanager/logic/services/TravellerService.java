package com.travelmanager.logic.services;


import com.travelmanager.repositories.ITravellerRepository;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Traveller;

public class TravellerService extends HateoasService<Traveller, Integer> {

    private ITravellerRepository repository;

    public TravellerService(ITravellerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Class<? extends HateoasService<Traveller, Integer>> getClazz() {
        return this.getClass();
    }
}
