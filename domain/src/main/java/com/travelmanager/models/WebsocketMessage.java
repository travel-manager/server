package com.travelmanager.models;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Entity(name = "messages")
public class WebsocketMessage extends ResourceSupport {
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
}
