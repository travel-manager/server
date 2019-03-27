package models;

import java.util.HashMap;

public class PaymentRequest {
    private Traveller payer;
    private HashMap<Traveller, Double> payerReceives;
    private HashMap<Traveller, Double> payerDebt;

    public void addDebt(Traveller traveller, Double amount){
        payerDebt.put(traveller, amount);
    }
    public void addPayment(Traveller traveller, Double amount){
        payerReceives.put(traveller, amount);
    }

    public PaymentRequest(Traveller traveller){
        payer = traveller;
    }
}
