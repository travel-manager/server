package com.travelmanager.logic.services;


import com.travelmanager.dal.repositories.ITravellerRepository;
import com.travelmanager.domain.interfaces.logic.services.ITravellerHandler;
import com.travelmanager.domain.models.Traveller;

import java.util.List;

public class TravellerHandler implements ITravellerHandler {

    private ITravellerRepository repository;

    @Override
    public int login(String username, String password) {
        return 0;
    }

    @Override
    public int register(String firstname, String lastname, String username, String password) {
        return 0;
    }

    @Override
    public Integer create(Traveller entity) {
        try {
            return repository.save(entity).getId();
        } catch (Exception ex) {
            return -1;
        }
    }

    @Override
    public Traveller read(int id) {
        try {
            return repository.findById(id).get();
        } catch (Exception ex) {

            return null;
        }
    }

    @Override
    public Iterable<Traveller> readAll() {
        try {
            return repository.findAll();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Integer update(Traveller entity) {
        try {
            return repository.save(entity).getId();
        } catch (Exception ex) {
            return -1;
        }
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
