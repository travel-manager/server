package handlers;

import interfaces.logic.handlers.ITravellerHandler;
import models.Traveller;
import repositories.ITravellerRepository;

import java.util.List;

public class TravellerHandler implements ITravellerHandler {

    ITravellerRepository repository;

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
        return null;
    }

    @Override
    public Traveller read(int id) {
        return null;
    }

    @Override
    public List<Traveller> readAll() {
        return null;
    }

    @Override
    public List<Traveller> readRange(List<Integer> ids) {
        return null;
    }

    @Override
    public Integer update(Traveller entity) {
        return null;
    }

    @Override
    public Integer delete(int id) {
        return null;
    }
}
