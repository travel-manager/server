package com.travelmanager.services;


import com.travelmanager.repositories.ITravellerRepository;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Traveller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravellerService extends HateoasService<Traveller, Integer> {

    private ITravellerRepository repository;

    @Autowired
    public TravellerService(ITravellerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Traveller getByUsername(String username){
        return null;
    }

    @Override
    public Class<? extends HateoasService<Traveller, Integer>> getClazz() {
        return this.getClass();
    }
}
