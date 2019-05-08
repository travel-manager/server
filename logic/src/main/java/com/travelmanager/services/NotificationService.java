package com.travelmanager.services;

import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Notification;
import com.travelmanager.repositories.INotificationRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService extends HateoasService<Notification, Integer> {

    private INotificationRepository repository;

    @Autowired
    public NotificationService(INotificationRepository _repo) {
        super(_repo);
        repository = _repo;
    }

    public void update(Notification object){
        if(repository.findById(object.id).isPresent()){
            Notification ent = repository.findById(object.id).get();
            ent.setContent(object.getContent());
            ent.setIcon(object.getIcon());
            ent.setTimestamp(object.getTimestamp());
            ent.setTrip(object.getTrip());
            ent.setType(object.getType());
            repository.save(ent);
        }
    }

    @Override
    public Class<? extends HateoasService<Notification, Integer>> getClazz() {
        return this.getClass();
    }

    @Override
    public Class<? extends ResourceSupport> getType() {
        return Notification.class;
    }

    public List<Notification> getAllNotificationsByTripId(int tripId) {
        return repository.getAllMarkersByTripId(tripId);
    }

    public boolean deleteAllNotificationsByTripId(int tripId) {
        repository.deleteAllMarkersByTripId(tripId);
        return true;
    }
}
