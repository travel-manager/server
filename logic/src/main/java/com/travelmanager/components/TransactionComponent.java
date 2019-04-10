package com.travelmanager.components;

import com.travelmanager.interfaces.ITransactionService;
import com.travelmanager.models.Transaction;
import com.travelmanager.models.Traveller;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionComponent implements ITransactionService {

    @Override
    public List<Transaction> calculatePayRequestForTraveller(Traveller traveller) {
        return null;
    }
}
