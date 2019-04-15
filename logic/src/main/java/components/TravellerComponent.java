package components;

import enums.Gender;
import models.Traveller;
import models.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.ITravellerRepository;
import repositories.IUserRepository;

import java.util.List;

public class TravellerComponent {

    @Autowired
    ITravellerRepository travellerRepository;

    @Autowired
    IUserRepository userRepository;

    public Traveller login(String username, String password) {
        Traveller result = null;
        User u = getUser(username);
        if(u != null){
            if(checkpassword(password, u.getPassword())){
                result = getTraveller(username);
            }
        }
        return  result;
    }

    public Traveller register(String email, String firstname, String lastname, String username, String password, Gender gender) {
        Traveller result = null;
        if(getUser(username) == null){
            String hashedpassword = hashpassword(password);
            User user = null;
            if(createUser(user)){
                return null;
            }
            Traveller traveller = null;
            if(createTraveller(traveller)){
                return null;
            }
            result = traveller;
        }else{
            return null;
        }
        return result;
    }

    private User getUser(String username){
        User user = null;
        try {
            List<User> accountList = userRepository.queryForAll();

            for (User u: accountList) {
                if(u.getUsername().equals(username)){
                    user = u;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return user;
    }

    private Traveller getTraveller(String username){
        Traveller traveller = null;
        try {
            List<Traveller> accountList = travellerRepository.queryForAll();

            for (Traveller tr: accountList) {
                if(tr.getUsername().equals(username)){
                    traveller = tr;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return traveller;
    }

    private String hashpassword(String plaintext){
        return BCrypt.hashpw(plaintext,BCrypt.gensalt());
    }

    private boolean checkpassword(String plaintext, String hashed){
        return BCrypt.checkpw(plaintext,hashed);
    }

    private boolean createUser(User u){
        try {
            userRepository.create(u);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean createTraveller(Traveller tr){
        try {
            travellerRepository.create(tr);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
