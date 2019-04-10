package com.travelmanager.models;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.List;

@Getter
@Entity(name = "transaction")
public class Transaction extends ResourceSupport {
    @Id
    @GeneratedValue
    private Integer id;

    public Link getId() {
        return new Link(id.toString());
    }
    @JoinTable(name = "members",joinColumns = @JoinColumn(name = "Trips",columnDefinition = "id"),inverseJoinColumns = @JoinColumn(name = "Travellers", columnDefinition = "id"))
    private Traveller payer;
    private Trip trip;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "freeloader")
    private String freeloaders;
    @Column(name = "subject")
    private String subject;
    @Column(name = "unit")
    private String unit;

    public Transaction() {
    }

    public Transaction(Traveller payer, Trip trip, Double amount, String freeloaders, String subject, String unit) {
        this.payer = payer;
        this.trip = trip;
        this.amount = amount;
        this.freeloaders = freeloaders;
        this.subject = subject;
        this.unit = unit;
    }
}
