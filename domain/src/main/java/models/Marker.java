package models;

import enums.MarkerType;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity(name = "pin")
public class Marker extends StorableItem{
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

    public Marker(int id, String markerJsonString, Traveller placedBy, Trip trip, String note, String location, MarkerType type) {
        super(id);
        this.markerJsonString = markerJsonString;
        this.placedBy = placedBy;
        this.trip = trip;
        this.note = note;
        this.location = location;
        this.type = type;
    }


}
