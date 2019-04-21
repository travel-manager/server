package com.travelmanager.controller;

import com.google.gson.Gson;
import com.travelmanager.enums.Gender;
import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Transaction;
import com.travelmanager.models.Traveller;
import com.travelmanager.services.TransactionService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends HateoasController<Transaction, Integer> {

    Gson json = new Gson();

    @Setter
    private TransactionService service;

    @Autowired
    public TransactionController(TransactionService _service) {
        super(_service);
    }

    @Override
    public Class<? extends HateoasController<Transaction, Integer>> getClazz() {
        return this.getClass();
    }

    @RequestMapping(value = "/getallbypayerandtripid", method = RequestMethod.POST)
    public ResponseEntity<String> getAllByPayerAndTripId(@RequestParam(name = "payer") String payer, @RequestParam(name = "tripId") int tripId){
        return new ResponseEntity<String>(json.toJson(service.getAllByPayerAndTripId(payer,tripId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/getallbypayerandtripid", method = RequestMethod.POST)
    public ResponseEntity<String> getAllByFreeLoaderAndTripId(@RequestParam(name = "freeloader") String freeLoader, @RequestParam(name = "tripId") int tripId){
        return new ResponseEntity<String>(json.toJson(service.getAllByFreeLoaderAndTripId(freeLoader,tripId)), HttpStatus.OK);
    }

}
