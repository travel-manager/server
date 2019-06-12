package com.travelmanager.models;

import com.travelmanager.interfaces.HateoasObject;
import lombok.Getter;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column(name = "accepted")
    private boolean accepted;

    @Getter
    @OneToOne
    @JoinColumn(name = "trips_id", referencedColumnName = "id")
    private Trip trip;

    @Getter
    @OneToOne
    @JoinColumn(name = "travellers_id", referencedColumnName = "id")
    private Traveller traveller;

    @Getter
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
