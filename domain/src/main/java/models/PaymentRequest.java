package models;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class PaymentRequest {
    private Traveller payer;
    private HashMap<Traveller, Double> payerReceives = new HashMap<>();
    private HashMap<Traveller, Double> payerDebt = new HashMap<>();

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
