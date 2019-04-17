package com.travelmanager.components;

import com.google.gson.Gson;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Traveller;
import com.travelmanager.models.User;
import com.travelmanager.repositories.ITravellerRepository;
import com.travelmanager.repositories.IUserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TravellerComponent {

    private ITravellerRepository travellerRepository;
    private IUserRepository userRepository;

    public TravellerComponent(ITravellerRepository travellerRepository, IUserRepository userRepository) {
        this.travellerRepository = travellerRepository;
        this.userRepository = userRepository;
    }


    public Traveller login(String username, String password) {
        Traveller result;
        User u = getUser(username);
        if(u != null){
            if(checkpassword(password, u.getPassword())){
                result = getTraveller(username);
            }else{
                return new Traveller();
            }
        }else{
            return new Traveller();
        }
        return  result;
    }

    public Traveller register(Traveller tr, String password) {
        Traveller result;
        if(getUser(tr.getUsername()) == null){
            User user = new User(tr.getUsername(), hashpassword(password));
            if(!createUser(user)){
                return null;
            }
            if(!createTraveller(tr)){
                return null;
            }
            result = tr;
        }else{
            return new Traveller();
        }
        return result;
    }

    private User getUser(String username){
        try {
            return userRepository.getUserByUsername(username);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    private Traveller getTraveller(String username){
        try {
            return travellerRepository.getTravellerByUsername(username);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    private String hashpassword(String plaintext){
        return BCrypt.hashpw(plaintext,BCrypt.gensalt());
    }

    private boolean checkpassword(String plaintext, String hashed){
        return BCrypt.checkpw(plaintext,hashed);
    }

    private boolean createUser(User u){
        try {
            userRepository.save(u);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    private boolean createTraveller(Traveller tr){
        try {
            travellerRepository.save(tr);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

}
