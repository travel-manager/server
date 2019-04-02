package com.travelmanager.logic.services;

import com.travelmanager.dal.repositories.ITransactionRepository;
import com.travelmanager.domain.interfaces.logic.services.ITransactionService;
import com.travelmanager.domain.models.Transaction;
import com.travelmanager.domain.models.Traveller;

import java.util.List;

public class TransactionService implements ITransactionService {
    private ITransactionRepository repository;

    @Override
    public Integer create(Transaction entity) {
        try {
            return repository.save(entity).getId();
        } catch (Exception ex) {
            return -1;
        }
    }

    @Override
    public Transaction read(int id) {
        try {
            return repository.findById(id).get();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Transaction> readAll() {
        try {
            return repository.findAll();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Integer update(Transaction entity) {
        try {
            return repository.save(entity).getId();
        } catch (Exception ex) {
            return -1;
        }
    }

    @Override
    public void delete(int id) {
            repository.deleteById(id);
    }

    public List<Transaction> calculatePayRequestForTraveller(Traveller traveller){
        try{
            return repository.getAllTransactionWhoPaid(traveller);
        }catch (Exception ex){
            return null;
        }
    }
}
