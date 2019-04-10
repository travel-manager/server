package com.travelmanager.controller;

import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Notification;
import com.travelmanager.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController extends HateoasController<Notification, Integer> {

    private NotificationService service;

    @Autowired
    public NotificationController(NotificationService _service) {
        super(_service);
    }

    @Override
    public Class<? extends HateoasController<Notification, Integer>> getClazz() {
        return null;
    }
}
