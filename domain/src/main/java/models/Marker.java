package models;

import enums.MarkerType;
import lombok.Getter;

@Getter
public class Marker extends StorableItem{
    private String markerJsonString;
    private Traveller creator;
    private String note;
    private MarkerType type;

    public Marker(int id, String markerJsonString, Traveller creator, String note, MarkerType type) {
        super(id);
        this.markerJsonString = markerJsonString;
        this.creator = creator;
        this.note = note;
        this.type = type;
    }
}
