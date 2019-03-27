package handlers;

import components.TransactionComponent;
import interfaces.logic.handlers.ITransactionHandler;
import models.PaymentRequest;
import models.Transaction;
import models.Traveller;
import repositories.ITransactionRepository;

import java.util.ArrayList;
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
        List<Transaction> allTransactions = readAll();
        List<Transaction> travellerTransactions = new ArrayList<>();
        for (Transaction t: allTransactions) {
            if (t.getPayer() == traveller)
                travellerTransactions.add(t);
            if (t.getFreeloaders().contains(traveller))
                travellerTransactions.add(t);
        }
        TransactionComponent transactionComponent = new TransactionComponent();
        return transactionComponent.calcPaymentRequest(travellerTransactions, traveller);
    }
}
