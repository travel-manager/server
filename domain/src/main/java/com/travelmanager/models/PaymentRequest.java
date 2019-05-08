//package com.travelmanager.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.travelmanager.hateoas.abstracts.HateoasObject;
//import lombok.Getter;
//import org.springframework.hateoas.Link;
//import org.springframework.hateoas.ResourceSupport;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import java.io.Serializable;
//import java.util.HashMap;
//
//@Getter
//public class PaymentRequest  extends ResourceSupport implements HateoasObject {
//    @Id
//    @GeneratedValue
//    private Integer id;
//
//    public Link getId() {
//        return new Link(id.toString());
//    }
//    private Traveller payer;
//    private HashMap<Traveller, Double> payerReceives;
//    private HashMap<Traveller, HashMap<Traveller, Double>> payerDebt;
//
//    public PaymentRequest(Traveller payer, HashMap<Traveller, Double> payerReceives, HashMap<Traveller, HashMap<Traveller, Double>> payerDebt) {
//        this.payer = payer;
//        this.payerReceives = payerReceives;
//        this.payerDebt = payerDebt;
//    }
//
//    @Override
//    @JsonIgnore
//    public Serializable getIdentifier() {
//        return this.id;
//    }
//}
