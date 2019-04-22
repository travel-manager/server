package com.travelmanager.models;

import com.travelmanager.enums.MarkerType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Setter
@Entity(name = "Markers")
public class Marker  extends ResourceSupport {
    @Id
    @GeneratedValue
    public Integer id;

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

    @Getter @Column(name = "lat")
    private Float latitude;
    @Getter @Column(name = "long")
    private Float longtitude;
    @Getter @Column(name = "type")
    private String type;
    @Getter @Column(name = "creator")
    private String creator;
    @Getter @Column(name = "note")
    private String note;
    @Getter @OneToOne
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
}
