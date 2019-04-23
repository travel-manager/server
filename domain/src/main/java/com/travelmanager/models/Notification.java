package com.travelmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelmanager.enums.NotificationType;
import com.travelmanager.hateoas.abstracts.HateoasObject;
import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Entity(name = "Notifications")
public class Notification extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    private Integer id;

    public Link getId() {
        return new Link(id.toString());
    }

    @Column(name = "timestamp")
    private String timestamp;
    @Column(name = "type")
    private String type;
    @Column(name = "content")
    private String content;
    @Column(name = "icon")
    private String icon;
    @OneToOne
    @JoinColumn(name = "id",table = "trips")
    private Trip trip;

    public Notification() {
    }

    public Notification(String timestamp, String type, String content, String icon, Trip trip) {
        this.timestamp = timestamp;
        this.type = type;
        this.content = content;
        this.icon = icon;
        this.trip = trip;
    }

    @Override
    @JsonIgnore
    public Serializable getIdentifier() {
        return this.id;
    }
}
