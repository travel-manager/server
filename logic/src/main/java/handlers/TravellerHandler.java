package handlers;

import enums.Gender;
import interfaces.logic.handlers.ITravellerHandler;
import models.Traveller;
import repositories.ITravellerRepository;

import java.util.List;

public class TravellerHandler implements ITravellerHandler {

    private ITravellerRepository repository;

    @Override
    public Integer create(Traveller entity) {
        try {
            return repository.create(entity);
        } catch (Exception ex) {
            return -1;
        }
    }

    @Override
    public Traveller read(int id) {
        try {
            return repository.queryForId(id);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Traveller> readAll() {
        try {
            return repository.queryForAll();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Integer update(Traveller entity) {
        try {
            return repository.update(entity);
        } catch (Exception ex) {
            return -1;
        }
    }

    @Override
    public Integer delete(int id) {
        try {
            return repository.delete(repository.queryForId(id));
        } catch (Exception ex) {
            return -1;
        }
    }


}
