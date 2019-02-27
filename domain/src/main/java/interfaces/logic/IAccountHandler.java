package interfaces.logic;

import interfaces.ICRUD;
import models.Traveller;

public interface IAccountHandler extends ICRUD<Traveller> {
    void login(String username, String password);
    void register(String firstname, String lastname, String username, String password);
}
