package com.travelmanager.services;

import com.travelmanager.models.Traveller;
import com.travelmanager.repositories.ITripRepository;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Trip;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Service;

@Service
public class TripService extends HateoasService<Trip, Integer> {

    @Setter
    private ITripRepository repository;

    @Autowired
    public TripService(ITripRepository repository) {
        super(repository);
    }

    public void update(Trip trip){
        if(repository.findById(trip.id).isPresent()){
            Trip tr = repository.findById(trip.id).get();
            tr.setDateend(trip.getDateend());
            tr.setDatestart(tr.getDatestart());
            tr.setDescription(trip.getDescription());
            tr.setIsPublic(trip.getIsPublic());
            tr.setLatitude(trip.getLatitude());
            tr.setLongtitude(trip.getLongtitude());
            tr.setLocation(trip.getLocation());
            tr.setName(trip.getName());
            tr.setOwner(trip.getOwner());
            tr.setPicture(trip.getPicture());
            tr.setTravellerList(trip.getTravellerList());
            repository.save(tr);
        }
    }

    @Override
    public Class<? extends HateoasService<Trip, Integer>> getClazz() {
        return this.getClass();
    }

    @Override
    public Class<? extends ResourceSupport> getType() {
        return Trip.class;
    }
}
