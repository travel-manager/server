package com.travelmanager.components;

import com.travelmanager.interfaces.ITransactionService;
import com.travelmanager.refactoredModels.Transaction;
import com.travelmanager.refactoredModels.Traveller;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionComponent implements ITransactionService {

    @Override
    public Transaction calculatePayRequestForTraveller(Traveller traveller) {
        return null;
    }
}
