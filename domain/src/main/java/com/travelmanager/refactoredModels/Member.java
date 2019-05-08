package com.travelmanager.refactoredModels;

import com.travelmanager.hateoas.abstracts.HateoasObject;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Entity(name = "members")
@NoArgsConstructor
public class Member extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private boolean accepted;

    @OneToOne
    @JoinColumn(name = "trips_id", referencedColumnName = "id")
    private Trip trip;

    @OneToOne
    @JoinColumn(name = "travellers_id", referencedColumnName = "id")
    private Traveller traveller;

    @OneToOne
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    private Role role;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Member(boolean accepted, Trip trip, Traveller traveller, Role role) {
        this.accepted = accepted;
        this.trip = trip;
        this.traveller = traveller;
        this.role = role;
    }
}
