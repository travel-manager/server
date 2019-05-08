package com.travelmanager.services;

import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Marker;
import com.travelmanager.repositories.IMarkerRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
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
        if(repository.findById(object.id).isPresent()){
            Marker ent = repository.findById(object.id).get();
            ent.setLatitude(object.getLatitude());
            ent.setLongtitude(object.getLongtitude());
            ent.setNote(object.getNote());
            ent.setType(object.getType());
            repository.save(ent);
        }
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
