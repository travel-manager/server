package com.travelmanager.services;

import com.travelmanager.components.TransactionComponent;
import com.travelmanager.repositories.ITransactionRepository;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.interfaces.ITransactionService;
import com.travelmanager.models.Transaction;
import com.travelmanager.models.Traveller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService extends HateoasService<Transaction, Integer> implements ITransactionService {

    private ITransactionRepository repository;

    private TransactionComponent component;

    @Autowired
    public TransactionService(ITransactionRepository _repository, TransactionComponent _component) {
        super(_repository);
        this.repository = _repository;
        this.component = _component;
    }

    @Override
    public Transaction calculatePayRequestForTraveller(Traveller traveller) {
        // TODO: 10-4-2019 let component handle the calculation 
        return repository.getAllTransactionWhoPaid(traveller);
    }

    @Override
    public Class<? extends HateoasService<Transaction, Integer>> getClazz() {
        return this.getClass();
    }

    @Override
    public Class<? extends ResourceSupport> getType() {
        return Transaction.class;
    }
}