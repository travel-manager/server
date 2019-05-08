package com.travelmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelmanager.interfaces.HateoasObject;
import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity(name = "Messages")
public class Message  extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    private Integer id;

    public Link getId() {
        return new Link(id.toString());
    }

    @Column(name = "timestamp")
    private String timestamp;
    @Column(name = "content")
    private String content;
    @OneToOne
    private Traveller traveller;
    @ManyToOne
    private Trip trip;

    /*public Message(Traveller sender, String content, Timestamp timeSent) {
        this.sender = sender;
        this.content = content;
        this.timeSent = timeSent;
    }*/

    public Message(String timestamp, String content, Traveller traveller, Trip trip) {
        this.timestamp = timestamp;
        this.content = content;
        this.traveller = traveller;
        this.trip = trip;
    }

    @Override
    @JsonIgnore
    public Serializable getIdentifier() {
        return this.id;
    }
}
