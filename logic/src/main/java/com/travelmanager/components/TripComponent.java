package com.travelmanager.components;

import com.travelmanager.models.Traveller;
import com.travelmanager.models.Trip;
import com.travelmanager.repositories.ITripRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TripComponent {

    @Setter
    private ITripRepository repository;

    @Autowired
    public TripComponent(ITripRepository repository) {
        this.repository  = repository;
    }

    public void addTraveller(Trip trip, Traveller traveller) {
        trip.getMembers().add(traveller);
        repository.save(trip);
    }

    public void removeTraveller(Trip trip, Traveller traveller) {
        trip.getMembers().remove(traveller);
        repository.save(trip);
    }
}
