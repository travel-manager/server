package handlers;

import interfaces.logic.IAccountHandler;
import models.Traveller;

import java.util.List;

public class AccountHandler implements IAccountHandler {
    @Override
    public void login(String username, String password) {

    }

    @Override
    public void register(Traveller traveller) {

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
