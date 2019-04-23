package com.travelmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelmanager.hateoas.abstracts.HateoasObject;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "messages")
public class WebsocketMessage extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "idTravellers")
    private Integer idTravellers;
    @Column(name = "idTrips")
    private Integer idTrips;

    private String content;
    private String timestamp;

    public WebsocketMessage() {
    }

    public WebsocketMessage(Integer idTravellers, Integer idTrips, String content, String timestamp) {
        this.idTravellers = idTravellers;
        this.idTrips = idTrips;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Override
    @JsonIgnore
    public Serializable getIdentifier() {
        return this.id;
    }
}
