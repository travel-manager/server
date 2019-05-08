package com.travelmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelmanager.interfaces.HateoasObject;
import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity(name = "markers")
public class Marker  extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    private Integer id;

    public Link getId() {
        return new Link(id.toString());
    }
    /*private String markerJsonString;
    @OneToOne
    private Traveller placedBy;
    @ManyToOne
    @JoinColumn(name = "TripId")
    private Trip trip;
    @Column(name = "Note")
    private String note;
    @Column(name = "Location")
    private String location;
    private MarkerType type;*/

    @Column(name = "lat")
    private Float latitude;
    @Column(name = "long")
    private Float longtitude;
    @Column(name = "type")
    private String type;
    @Column(name = "creator")
    private String creator;
    @Column(name = "note")
    private String note;
    @OneToOne
    @JoinColumn(name = "id",table = "trips")
    private Trip trip;

    public Marker() {
    }

    public Marker(Float latitude, Float longtitude, String type, String creator, String note, Trip trip) {
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.type = type;
        this.creator = creator;
        this.note = note;
        this.trip = trip;
    }

    @Override
    @JsonIgnore
    public Serializable getIdentifier() {
        return this.id;
    }
}
