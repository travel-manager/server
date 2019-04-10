package com.travelmanager.logic.services;

import com.travelmanager.dal.repositories.ITransactionRepository;
import com.travelmanager.domain.interfaces.logic.services.ITransactionService;
import com.travelmanager.models.Transaction;
import com.travelmanager.models.Traveller;

import java.util.List;

public class TransactionService implements ITransactionService {

    private ITransactionRepository repository;

    @Override
    public List<Transaction> calculatePayRequestForTraveller(Traveller traveller) {
        return repository.getAllTransactionWhoPaid(traveller);
    }
}
