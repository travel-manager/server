package com.travelmanager.services;

import com.travelmanager.models.Marker;
import com.travelmanager.repositories.IMarkerRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Service;

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

    public void update(Marker object){
        if(repo.findById(object.id).isPresent()){
            Marker ent = repo.findById(object.id).get();
            ent.setLocation(object.getLocation());
            ent.setType(object.getType());
            repo.save(ent);
        }
    }

    @Override
    public Class<? extends HateoasService<Marker, Integer>> getClazz() {
        return this.getClass();
    }

    @Override
    public Class<? extends ResourceSupport> getType() {
        return Marker.class;
    }

    public List<Marker> getAllMarkersByTripId(int tripId){
        return repo.getAllMarkersByTripId(tripId);
    }

    public Boolean deleteAllMarkersByTripId(int tripId){
        repo.deleteAllMarkersByTripId(tripId);
        return true;
    }
}
