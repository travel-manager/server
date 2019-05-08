package com.travelmanager.services;

import com.travelmanager.repositories.ITripRepository;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Trip;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class TripService extends HateoasService<Trip, Integer> {

    @Setter
    private ITripRepository repository;

    @Autowired
    public TripService(ITripRepository repository) {
        super(repository);
        this.repository  = repository;
    }

    public List<Trip> getAllByDateEndAndDateStart(Date dateStart, Date dateEnd, Boolean isPublic){
        if(dateEnd.after(dateStart)){
            return repository.getAllBetweenDates(dateStart,dateEnd);// get trips public and start na datestart en end voor dateend;
        }else{
            List<Trip> trips = new ArrayList<>();
            trips.add(null);
            return trips;
        }
    }

    public List<Trip> getAllByLatAndLong(Float latitude, Float longitude, Float range){
        if(range != null){
            Float latMinusRange = latitude - range;
            Float latPlusRange = latitude + range;
            Float longMinusRange = longitude - range;
            Float longPlusRange = latitude + range;
            return repository.getAllBetweenLatAndLongWithRange(latMinusRange, latPlusRange, longMinusRange, longPlusRange);
        }else{
            return repository.getAllBetweenLatAndLong(latitude,longitude);
        }
    }

    @Override
    public Class<? extends HateoasService<Trip, Integer>> getClazz() {
        return this.getClass();
    }
}
