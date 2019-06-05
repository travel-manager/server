package com.travelmanager.controller;

import com.google.gson.Gson;
import com.travelmanager.annotations.LoginRequired;
import com.travelmanager.models.Notification;
import com.travelmanager.services.NotificationService;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController extends HateoasController<Notification, Integer> {

    Gson json = new Gson();

    @Setter
    private NotificationService service;

    public NotificationController(NotificationService _service) {
        super(_service);
        service = _service;
    }

    @Override
    public Class<? extends HateoasController<Notification, Integer>> getClazz() {
        return this.getClass();
    }

    @Override
    public Class<? extends ResourceSupport> getType() {
        return Notification.class;
    }

    @RequestMapping(value = "/byTrip", method = RequestMethod.GET)
    public ResponseEntity<String> getAllNotificationsByTripId(@RequestParam(name = "tripid") int tripId){
        return new ResponseEntity<String>(json.toJson(service.getAllNotificationsByTripId(tripId)), HttpStatus.OK);
    }

    @LoginRequired
    @RequestMapping(value = "/byTrip", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteAllNotificationsByTripId(@RequestParam(name = "tripid") int tripId){
        if(service.deleteAllNotificationsByTripId(tripId)){
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }else{
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
