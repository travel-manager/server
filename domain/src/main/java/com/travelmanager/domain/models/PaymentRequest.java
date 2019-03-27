package com.travelmanager.domain.models;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class PaymentRequest {
    private Traveller payer;
    private HashMap<Traveller, Double> payerReceives;
    private HashMap<Traveller, HashMap<Traveller, Double>> payerDebt;

    public PaymentRequest(Traveller payer, HashMap<Traveller, Double> payerReceives, HashMap<Traveller, HashMap<Traveller, Double>> payerDebt) {
        this.payer = payer;
        this.payerReceives = payerReceives;
        this.payerDebt = payerDebt;
    }
}
