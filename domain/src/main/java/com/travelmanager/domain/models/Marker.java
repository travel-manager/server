package com.travelmanager.domain.models;

import com.travelmanager.domain.enums.MarkerType;
import com.travelmanager.hateoas.abstracts.PersistenceEntity;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Getter
@Entity(name = "pin")
public class Marker extends PersistenceEntity<Integer> {
    private String markerJsonString;
    @OneToOne
    @Column(name = "PlacedBy")
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
