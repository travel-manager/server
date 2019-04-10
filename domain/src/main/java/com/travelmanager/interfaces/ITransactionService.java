package com.travelmanager.interfaces;

import com.travelmanager.models.Transaction;
import com.travelmanager.models.Traveller;

import java.util.List;

public interface ITransactionService {
    List<Transaction> calculatePayRequestForTraveller(Traveller traveller);
}
