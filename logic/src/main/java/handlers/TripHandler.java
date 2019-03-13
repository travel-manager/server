package handlers;

import interfaces.logic.handlers.ITripHandler;
import models.Trip;
import repositories.ITripRepository;

import java.util.List;

public class TripHandler implements ITripHandler {

    private ITripRepository repository;

    @Override
    public Integer create(Trip entity) {
        try {
            return repository.create(entity);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Trip read(int id) {
        try {
            return repository.queryForId(id);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Trip> readAll() {
        try {
            return repository.queryForAll();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Integer update(Trip entity) {
        try {
            return repository.update(entity);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Integer delete(int id) {
        try {
            return repository.delete(read(id));
        } catch (Exception ex) {
            return null;
        }
    }
}
