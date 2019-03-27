package com.travelmanager.logic.services;

import com.travelmanager.dal.repositories.ITripRepository;
import com.travelmanager.domain.interfaces.logic.services.ITripHandler;
import com.travelmanager.domain.models.Trip;

public class TripHandler implements ITripHandler {

    private ITripRepository repository;

    @Override
    public Integer create(Trip entity) {
        try {
            return repository.save(entity).getId();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Trip read(int id) {
        try {
            return repository.findById(id).get();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Iterable<Trip> readAll() {
        try {
            return repository.findAll();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Integer update(Trip entity) {
        try {
            return repository.save(entity).getId();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
