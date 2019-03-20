package models;

import java.util.HashMap;

public class PaymentRequest {
    private Traveller payer;
    private HashMap<Traveller, Double> payerReceives;
    private HashMap<Traveller, HashMap<Traveller, Double>> payerDebt;
}
