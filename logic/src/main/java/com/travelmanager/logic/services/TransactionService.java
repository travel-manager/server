package com.travelmanager.logic.services;

import com.travelmanager.repositories.ITransactionRepository;
import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.interfaces.ITransactionService;
import com.travelmanager.models.Transaction;
import com.travelmanager.models.Traveller;

import java.util.List;

public class TransactionService extends HateoasService<Transaction, Integer> implements ITransactionService {

    private ITransactionRepository repository;

    public TransactionService(ITransactionRepository repository) {
        super(repository);
        repository = repository;
    }


    @Override
    public List<Transaction> calculatePayRequestForTraveller(Traveller traveller) {
        return repository.getAllTransactionWhoPaid(traveller);
    }

    @Override
    public Class<? extends HateoasService<Transaction, Integer>> getClazz() {
        return this.getClass();
    }
}