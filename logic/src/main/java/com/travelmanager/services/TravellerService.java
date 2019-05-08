package com.travelmanager.services;


import com.travelmanager.components.TravellerComponent;
import com.travelmanager.refactoredModels.Role;
import com.travelmanager.repositories.ITravellerRepository;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.refactoredModels.Traveller;
import com.travelmanager.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravellerService extends HateoasService<Traveller, Integer> {

    private ITravellerRepository travellerRepository;
    private IUserRepository userRepository;
    private TravellerComponent component;

    @Autowired
    public TravellerService(ITravellerRepository travellerRepository, IUserRepository userRepository) {
        super(travellerRepository);
        this.travellerRepository = travellerRepository;
        this.userRepository = userRepository;
        component = new TravellerComponent(travellerRepository, userRepository);
    }

    public Traveller login(String username, String password){
        return component.login(username, password);
    }

    public Traveller register(Traveller tr, String password, Role role){
        return component.register(tr, password, role);
    }

    public Boolean test(Traveller tr){
        return component.createTraveller(tr);
    }

    public Traveller getByUsername(String username){
        return travellerRepository.getByUsername(username);
    }

    @Override
    public Class<? extends HateoasService<Traveller, Integer>> getClazz() {
        return this.getClass();
    }
}
