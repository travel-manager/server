package com.travelmanager.controller;

import com.google.gson.Gson;
import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.models.Notification;
import com.travelmanager.services.NotificationService;
import lombok.Setter;
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

    @RequestMapping(value = "/getallbytrip", method = RequestMethod.GET)
    public ResponseEntity<String> getAllNotificationsByTripId(@RequestParam(name = "tripid") int tripId){
        return new ResponseEntity<String>(json.toJson(service.getAllNotificationsByTripId(tripId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteallbytrip", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteAllNotificationsByTripId(@RequestParam(name = "tripid") int tripId){
        if(service.deleteAllNotificationsByTripId(tripId)){
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }else{
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
