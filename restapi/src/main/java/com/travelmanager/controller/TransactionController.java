package com.travelmanager.controller;

import com.google.gson.Gson;
import com.travelmanager.models.Transaction;
import com.travelmanager.services.TransactionService;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController extends HateoasController<Transaction, Integer> {

    Gson json = new Gson();

    @Setter
    private TransactionService service;

    public TransactionController(TransactionService _service) {
        super(_service);
        service = _service;
    }

    @Override
    public Class<? extends HateoasController<Transaction, Integer>> getClazz() {
        return this.getClass();
    }

    @Override
    public Class<? extends ResourceSupport> getType() {
        return Transaction.class;
    }

    @RequestMapping(value = "/byPayerAndTrip", method = RequestMethod.GET)
    public ResponseEntity<String> getAllByPayerAndTripId(@RequestParam(name = "payer") int payer, @RequestParam(name = "tripId") int tripId){
        return new ResponseEntity<String>(json.toJson(service.getAllByPayerAndTripId(payer,tripId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/byFreeloaderAndTrip", method = RequestMethod.GET)
    public ResponseEntity<String> getAllByFreeLoaderAndTripId(@RequestParam(name = "tripId") int tripId){
        return new ResponseEntity<String>(json.toJson(service.getAllByFreeLoaderAndTripId(tripId)), HttpStatus.OK);
    }

}
