package com.travelmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelmanager.interfaces.HateoasObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Entity(name = "transactions")
@NoArgsConstructor
public class Transaction extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Getter
    @Column(name = "amount")
    private double amount;

    @Getter
    @Column(name = "subject")
    private String subject;

    @Getter
    @OneToOne
    @JoinColumn(name = "units_id", referencedColumnName = "id")
    private Unit unit;

    @Getter
    @OneToOne
    @JoinColumn(name = "payer",referencedColumnName = "id")
    private Traveller payer;

    @Getter
    @OneToOne
    @JoinColumn(name = "trips_id",referencedColumnName = "id")
    private Trip trip;

    @Getter
    @OneToMany(mappedBy = "transaction", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Freeloader> freeloaders;


    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Transaction(double amount, String subject, Unit unit, Traveller payer, Trip trip) {
        this.amount = amount;
        this.subject = subject;
        this.unit = unit;
        this.payer = payer;
        this.trip = trip;
    }
}
