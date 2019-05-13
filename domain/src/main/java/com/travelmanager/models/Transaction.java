package com.travelmanager.models;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelmanager.interfaces.HateoasObject;
=======
import com.travelmanager.hateoas.abstracts.HateoasObject;
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35

@Setter
@Entity(name = "transactions")
@NoArgsConstructor
public class Transaction extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
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
