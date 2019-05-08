package com.travelmanager.interfaces;


import com.travelmanager.models.Transaction;
import com.travelmanager.models.Traveller;

public interface ITransactionService {
    Transaction calculatePayRequestForTraveller(Traveller traveller);
}
