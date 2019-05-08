package com.travelmanager.components;

import com.travelmanager.interfaces.ITransactionService;
import com.travelmanager.models.Transaction;
import com.travelmanager.models.Traveller;
import org.springframework.stereotype.Component;

@Component
public class TransactionComponent implements ITransactionService {

    @Override
    public Transaction calculatePayRequestForTraveller(Traveller traveller) {
        return null;
    }
}
