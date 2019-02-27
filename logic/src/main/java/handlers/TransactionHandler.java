package handlers;

import interfaces.logic.ITransactionHandler;
import interfaces.rest.ITransactionController;
import models.Transaction;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TransactionHandler implements ITransactionHandler {

    @Override
    public void create(Transaction entity) {

    }

    @Override
    public Transaction read(int id) {
        return null;
    }

    @Override
    public List<Transaction> readAll() {
        return null;
    }

    @Override
    public List<Transaction> readRange(List<Integer> ids) {
        return null;
    }

    @Override
    public void update(Transaction entity) {

    }

    @Override
    public void delete(int id) {

    }
}
