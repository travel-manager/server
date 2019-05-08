package com.travelmanager.services;

import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.refactoredModels.Marker;
import com.travelmanager.repositories.IMarkerRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkerService extends HateoasService<Marker, Integer> {

    @Setter
    private IMarkerRepository repo;

    @Autowired
    public MarkerService(IMarkerRepository _repo) {
        super(_repo);
        this.repo = _repo;
    }

    @Override
    public Class<? extends HateoasService<Marker, Integer>> getClazz() {
        return this.getClass();
    }

    public List<Marker> getAllMarkersByTripId(int tripId){
        return repo.getAllMarkersByTripId(tripId);
    }

    public Boolean deleteAllMarkersByTripId(int tripId){
        repo.deleteAllMarkersByTripId(tripId);
        return true;
    }
}
