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
    @OneToOne
    private Traveller payer;
    @Column(name = "Amount")
    private Double amount;
    @OneToMany
    private List<Traveller> freeloaders;
    @Column(name = "Subject")
    private String subject;
    @Column(name = "Date")
    private DateFormat date;

    public Transaction(int id, Traveller payer, Double amount, List<Traveller> freeloaders, String subject, DateFormat date) {
        this.payer = payer;
        this.amount = amount;
        this.freeloaders = freeloaders;
        this.subject = subject;
        this.date = date;
    }
}
