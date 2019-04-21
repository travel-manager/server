package com.travelmanager.services;

import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Notification;
import com.travelmanager.repositories.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Override
    public Class<? extends HateoasService<Notification, Integer>> getClazz() {
        return this.getClass();
    }

    public List<Notification> getAllNotificationsByTripId(int tripId) {
        return null;
    }

    public boolean deleteAllNotificationsByTripId(int tripId) {
        return false;
    }
}
