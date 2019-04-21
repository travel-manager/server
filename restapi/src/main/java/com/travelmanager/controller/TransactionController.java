package com.travelmanager.controller;

import com.travelmanager.enums.Gender;
import com.travelmanager.hateoas.abstracts.HateoasController;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Transaction;
import com.travelmanager.models.Traveller;
import com.travelmanager.services.TransactionService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends HateoasController<Transaction, Integer> {

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

    @Override
    public Class<? extends ResourceSupport> getType() {
        return Transaction.class;
    }
}
