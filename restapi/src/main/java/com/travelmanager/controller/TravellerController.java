package com.travelmanager.controller;

import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.hateoas.annotations.WrapWithLink;
import com.travelmanager.hateoas.utils.HateoasResponse;
import com.travelmanager.hateoas.utils.HateoasUtil;
import com.travelmanager.models.Traveller;
import com.travelmanager.services.TravellerService;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travellers")
public class TravellerController extends HateoasController<Traveller, Integer> {

    @Setter
    private TravellerService service;

    public TravellerController(TravellerService _service) {
        super(_service);
        service = _service;
    }

//    @Override
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseEntity<String> login(@RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password){
//        service.login(username,password);
//        return new ResponseEntity<String>(username + " : " + password, HttpStatus.OK);
//    }
//
//    @Override
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public ResponseEntity<String> register(@RequestParam(name = "firstName", required = true) String firstName, @RequestParam(name = "lastName", required = true) String lastName, @RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password){
//        service.register(firstName,lastName,username,password);
//        return new ResponseEntity<String>("First name: " + firstName + ", last name: " + lastName + ", username: " + username + ", password : " + password, HttpStatus.OK);
//    }

    @PutMapping(value = "/")
    @WrapWithLink
    public HttpEntity<HateoasResponse> update(@RequestBody Traveller entity) {
        service.update(entity);
        return HateoasUtil.build(entity);
    }


    @Override
    public Class<? extends HateoasController<Traveller, Integer>> getClazz() {
        return this.getClass();
    }

    @Override
    public Class<? extends ResourceSupport> getType() {
        return Traveller.class;
    }
}
