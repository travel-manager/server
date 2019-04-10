package com.travelmanager.models;

import com.travelmanager.enums.MarkerType;
import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Getter
@Entity(name = "pin")
public class Marker  extends ResourceSupport {
    @Id
    @GeneratedValue
    private Integer id;

    public Link getId() {
        return new Link(id.toString());
    }
    private String markerJsonString;
    @OneToOne
    private Traveller placedBy;
    @ManyToOne
    @JoinColumn(name = "TripId")
    private Trip trip;
    @Column(name = "Note")
    private String note;
    @Column(name = "Location")
    private String location;
    private MarkerType type;

    public Marker(String markerJsonString, Traveller placedBy, Trip trip, String note, String location, MarkerType type) {
        this.markerJsonString = markerJsonString;
        this.placedBy = placedBy;
        this.trip = trip;
        this.note = note;
        this.location = location;
        this.type = type;
    }


}
