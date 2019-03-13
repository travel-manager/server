package interfaces.logic.handlers;

import interfaces.ICRUD;
import models.Traveller;

public interface ITravellerHandler extends ICRUD<Traveller, Integer> {
    int login(String username, String password);
    int register(String firstname, String lastname, String username, String password);
}
