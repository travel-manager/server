package com.travelmanager.models;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;

@Getter
public class PaymentRequest  extends ResourceSupport {
    @Id
    @GeneratedValue
    private Integer id;

    public Link getId() {
        return new Link(id.toString());
    }
    private Traveller payer;
    private HashMap<Traveller, Double> payerReceives;
    private HashMap<Traveller, HashMap<Traveller, Double>> payerDebt;

    public PaymentRequest(Traveller payer, HashMap<Traveller, Double> payerReceives, HashMap<Traveller, HashMap<Traveller, Double>> payerDebt) {
        this.payer = payer;
        this.payerReceives = payerReceives;
        this.payerDebt = payerDebt;
    }
}
