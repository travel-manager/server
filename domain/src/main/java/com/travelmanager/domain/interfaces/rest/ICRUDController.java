package com.travelmanager.domain.interfaces.rest;

import org.springframework.http.ResponseEntity;

public interface ICRUDController {


    ResponseEntity create(String jsonString);

    ResponseEntity read(String jsonString);

    ResponseEntity update(String jsonString);

    ResponseEntity delete(String jsonString);
}
