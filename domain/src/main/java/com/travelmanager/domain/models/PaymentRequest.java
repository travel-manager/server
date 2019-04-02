package com.travelmanager.domain.models;

import com.travelmanager.hateoas.abstracts.PersistenceEntity;
import lombok.Getter;

import java.util.HashMap;

@Getter
public class PaymentRequest extends PersistenceEntity<Integer> {
    private Traveller payer;
    private HashMap<Traveller, Double> payerReceives;
    private HashMap<Traveller, HashMap<Traveller, Double>> payerDebt;

    public PaymentRequest(Traveller payer, HashMap<Traveller, Double> payerReceives, HashMap<Traveller, HashMap<Traveller, Double>> payerDebt) {
        this.payer = payer;
        this.payerReceives = payerReceives;
        this.payerDebt = payerDebt;
    }
}
