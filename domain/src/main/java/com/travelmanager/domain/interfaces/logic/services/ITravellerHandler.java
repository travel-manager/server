package com.travelmanager.domain.interfaces.logic.services;

import com.travelmanager.domain.interfaces.ICRUD;
import com.travelmanager.domain.models.Traveller;

public interface ITravellerHandler extends ICRUD<Traveller, Integer> {
    int login(String username, String password);
    int register(String firstname, String lastname, String username, String password);
}
