package handlers;

import interfaces.logic.handlers.ITransactionHandler;
import models.PaymentRequest;
import models.Transaction;
import models.Traveller;
import repositories.ITransactionRepository;

import java.util.List;

public class TransactionHandler implements ITransactionHandler {

    private ITransactionRepository repository;

    @Override
    public Integer create(Transaction entity) {
        try {
            return repository.create(entity);
        } catch (Exception ex) {
            return -1;
        }
    }

    @Override
    public Transaction read(int id) {
        try {
            return repository.queryForId(id);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Transaction> readAll() {
        try {
            return repository.queryForAll();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Integer update(Transaction entity) {
        try {
            return repository.update(entity);
        } catch (Exception ex) {
            return -1;
        }
    }

    @Override
    public Integer delete(int id) {
        try {
            return repository.delete(repository.queryForId(id));
        } catch (Exception ex) {
            return -1;
        }
    }

    public PaymentRequest calculatePayRequestForTraveller(Traveller traveller){
        return null;
    }
}
