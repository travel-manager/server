package com.travelmanager.services;


import com.travelmanager.repositories.ITravellerRepository;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Traveller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Convert;

@Service
public class TravellerService extends HateoasService<Traveller, Integer> {

    private ITravellerRepository repository;

    @Autowired
    public TravellerService(ITravellerRepository repository) {
        super(repository);
        this.repository = repository;
    }


    @Override
    public void update(Traveller traveller){
        if(repository.findById(traveller.id).isPresent()){
            Traveller tr = repository.findById(traveller.id).get();
            tr.setBio(traveller.getBio());
            System.out.println(tr.getFirstname());
            repository.save(tr);
        }
    }

    @Override
    public Class<? extends HateoasService<Traveller, Integer>> getClazz() {
        return this.getClass();
    }
}
