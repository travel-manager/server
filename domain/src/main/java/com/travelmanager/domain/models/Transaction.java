package com.travelmanager.domain.models;

import com.travelmanager.hateoas.abstracts.PersistenceEntity;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.text.DateFormat;
import java.util.List;

@Getter
@Entity(name = "transaction")
public class Transaction extends PersistenceEntity<Integer> {
    @OneToOne
    @Column(name = "Payer")
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