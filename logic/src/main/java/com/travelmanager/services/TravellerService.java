package com.travelmanager.services;


import com.travelmanager.components.TravellerComponent;
import com.travelmanager.repositories.ITravellerRepository;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Traveller;
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

    public Traveller register(Traveller tr, String password){
        return component.register(tr, password);
    }

    @Override
    public Class<? extends HateoasService<Traveller, Integer>> getClazz() {
        return this.getClass();
    }
}
