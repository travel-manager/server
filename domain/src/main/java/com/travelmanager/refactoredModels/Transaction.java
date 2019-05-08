package com.travelmanager.refactoredModels;

import com.travelmanager.interfaces.HateoasObject;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Entity(name = "transactions")
@NoArgsConstructor
public class Transaction extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private double amount;

    @Column
    private String subject;

    @OneToOne
    @JoinColumn(name = "units_id", referencedColumnName = "id")
    private Unit unit;

    @OneToOne
    @JoinColumn(name = "travellers_id",referencedColumnName = "id")
    private Traveller traveller;

    @OneToOne
    @JoinColumn(name = "trips_id",referencedColumnName = "id")
    private Trip trip;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Transaction(double amount, String subject, Unit unit, Traveller traveller, Trip trip) {
        this.amount = amount;
        this.subject = subject;
        this.unit = unit;
        this.traveller = traveller;
        this.trip = trip;
    }
}
