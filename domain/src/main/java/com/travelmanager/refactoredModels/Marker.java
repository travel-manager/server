package com.travelmanager.refactoredModels;

import com.travelmanager.interfaces.HateoasObject;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Entity(name = "markers")
@NoArgsConstructor
public class Marker extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private int type;

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "trips_id", referencedColumnName = "id")
    private Trip trip;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Marker(int type, Location location, Trip trip) {
        this.type = type;
        this.location = location;
        this.trip = trip;
    }
}
