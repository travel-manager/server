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

@Setter
@Entity(name = "markers")
@NoArgsConstructor
public class Marker extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    public Integer id;

    @Getter
    @Column(name = "type")
    private int type;

    @Getter
    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @Getter
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
