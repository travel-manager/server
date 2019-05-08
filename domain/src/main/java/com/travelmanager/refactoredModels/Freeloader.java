package com.travelmanager.refactoredModels;

import com.travelmanager.interfaces.HateoasObject;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Entity(name = "freeloaders")
@NoArgsConstructor
public class Freeloader extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    @JoinColumn(name = "travellers_id", referencedColumnName = "id")
    private Traveller traveller;

    @ManyToOne
    @JoinColumn(name = "transactions_id", referencedColumnName = "id")
    private Transaction transaction;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Freeloader(Traveller traveller, Transaction transaction) {
        this.traveller = traveller;
        this.transaction = transaction;
    }
}
