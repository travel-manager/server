package com.travelmanager.domain.interfaces.logic.services;

import com.travelmanager.domain.models.Traveller;

public interface ITravellerService {
    int login(String username, String password);
    int register(String firstname, String lastname, String username, String password);
}
