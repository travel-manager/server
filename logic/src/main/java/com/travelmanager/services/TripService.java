package com.travelmanager.services;

import com.travelmanager.repositories.ITripRepository;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Trip;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TripService extends HateoasService<Trip, Integer> {

    @Setter
    private ITripRepository repository;

    @Autowired
    public TripService(ITripRepository repository) {
        super(repository);
    }

    public List<Trip> getAllByDateEndAndDateStart(Date dateStart, Date dateEnd, Boolean isPublic){
        if(dateEnd.after(dateStart)){
            return null;// get trips public and start na datestart en end voor dateend;
        }else{
            List<Trip> trips = new ArrayList<>();
            trips.add(null);
            return trips;
        }
    }

    public List<Trip> getAllByLatAndLong(long latitude, long longitude, long range){
        long latMinusRange = latitude - range;
        long latPlusRange = latitude + range;
        long longMinusRange = longitude - range;
        long longPlusRange = latitude + range;
        return null;
    }

    @Override
    public Class<? extends HateoasService<Trip, Integer>> getClazz() {
        return this.getClass();
    }
}
