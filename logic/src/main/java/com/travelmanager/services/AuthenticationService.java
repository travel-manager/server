package com.travelmanager.services;

import com.nimbusds.jose.JOSEException;
import com.travelmanager.components.AuthenticationComponent;
import com.travelmanager.models.User;
import com.travelmanager.refactoredModels.Token;
import com.travelmanager.repositories.ITokenRepository;
import com.travelmanager.repositories.IUserRepository;
import com.travelmanager.utils.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class AuthenticationService {

    IUserRepository userRepository;
    ITokenRepository tokenRepository;

    AuthenticationComponent component;

    @Autowired
    public AuthenticationService(IUserRepository userRepository, ITokenRepository tokenRepository, AuthenticationComponent component) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.component = component;
    }

    public User register(User newUser, HttpServletRequest request) {
        String oriPassword = newUser.getPassword();
        newUser.setPassword(component.hashPassword(newUser.getPassword()));
        User savedUser = userRepository.save(newUser);
        return new User(newUser.getUsername(), oriPassword);
    }

    public Token login(User loginAttempt, HttpServletRequest request) throws JOSEException {
        final User foundUser = userRepository.findByUsername(loginAttempt.getUsername());
        if (foundUser != null
                && component.checkPassword(loginAttempt.getPassword(), foundUser.getPassword())) {
            final Token token = AuthUtils.createToken(request.getRemoteHost(), foundUser.getIdentifier().toString());
            return token;
        }
        return null;
    }



    /**
     * I wonder what this does.
     *
     * @param tokenString the token value to check for.
     * @return true if valid, false otherwise.
     */
    public boolean isAuthorized(final String tokenString) {
        if (tokenString == null) {
            return false;
        }
        String t = tokenString.replace("Bearer ", "");
        Token token = tokenRepository.findByToken(t);
        if (token == null)
            return false;
        return token.getTimesatamp().before(Timestamp.from(Instant.now()));
    }
}
