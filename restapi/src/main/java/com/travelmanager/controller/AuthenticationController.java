package com.travelmanager.controller;

import com.nimbusds.jose.JOSEException;
import com.travelmanager.models.Token;
import com.travelmanager.models.User;
import com.travelmanager.services.AuthenticationService;
import com.travelmanager.utils.HateoasResponse;
import com.travelmanager.utils.HateoasUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private AuthenticationService service;

    @Autowired
    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public HateoasResponse login(@RequestBody User loginAttempt, @Context final HttpServletRequest request) throws JOSEException {
        Token token = service.login(loginAttempt, request);
        if (token != null)
            return HateoasUtil.build(token).getBody();
        return HateoasUtil.build(null).getBody();
    }

    @PostMapping("/register")
    public HateoasResponse register(@RequestBody User newUser, HttpServletRequest request) throws JOSEException {
        User user = service.register(newUser, request);
        if (newUser.getId() != null) {
            return HateoasUtil.build(newUser).getBody();
        }
        return login(user, request);
    }
}
