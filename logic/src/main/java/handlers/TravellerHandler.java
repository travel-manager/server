package handlers;

import interfaces.logic.handlers.ITravellerHandler;
import models.Traveller;
import repositories.ITravellerRepository;

import java.util.List;

public class TravellerHandler implements ITravellerHandler {

    ITravellerRepository repository;

    @Override
    public void login(String username, String password) {
    }

    @Override
    public void register(String firstname, String lastname, String username, String password) {

    }

    @Override
    public void create(Traveller entity) {

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
    public void update(Traveller entity) {

    }

    @Override
    public void delete(int id) {

    }
}
