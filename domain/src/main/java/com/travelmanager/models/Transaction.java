package com.travelmanager.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.List;

@Setter
@Entity(name = "Transactions")
public class Transaction extends ResourceSupport {
    @Id
    @GeneratedValue
    public Integer id;

    @Getter @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",table = "travellers")
    private Traveller payer;
    /*@OneToOne
    @JoinColumn(name = "idTrips",referencedColumnName = "id")
*/
    @Getter @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",table = "trips")
    private Trip trip;
    @Getter @Column(name = "amount")
    private Double amount;
    @Getter @Column(name = "freeloader")
    private String freeloaders;
    @Getter @Column(name = "subject")
    private String subject;
    @Getter @Column(name = "unit")
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
