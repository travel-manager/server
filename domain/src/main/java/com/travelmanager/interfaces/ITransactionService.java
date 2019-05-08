package com.travelmanager.interfaces;


import com.travelmanager.refactoredModels.Transaction;
import com.travelmanager.refactoredModels.Traveller;

import java.util.List;

public interface ITransactionService {
    Transaction calculatePayRequestForTraveller(Traveller traveller);
}
