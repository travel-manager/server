package com.travelmanager.logic.services;


import com.travelmanager.dal.repositories.ITravellerRepository;
import com.travelmanager.domain.interfaces.logic.services.ITravellerService;
import com.travelmanager.models.Traveller;

public class TravellerService implements ITravellerService {

    private ITravellerRepository repository;

    @Override
    public int login(String username, String password) {
        return 0;
    }

    @Override
    public int register(String firstname, String lastname, String username, String password) {
        return 0;
    }
}
