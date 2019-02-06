package models;

import lombok.Getter;

@Getter
public class Marker {
    private String markerJsonString;
    private Traveller creator;
    private String note;
    private MarkerType type;

    public Marker(String markerJsonString, Traveller creator, String note, MarkerType type) {
        this.markerJsonString = markerJsonString;
        this.creator = creator;
        this.note = note;
        this.type = type;
    }
}
