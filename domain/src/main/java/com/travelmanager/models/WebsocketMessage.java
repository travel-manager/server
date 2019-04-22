package com.travelmanager.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Setter
@Entity(name = "messages")
public class WebsocketMessage extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Getter
    @Column(name = "idTravellers")
    private Integer idTravellers;
    @Getter
    @Column(name = "idTrips")
    private Integer idTrips;

    @Getter
    private String content;
    @Getter
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
