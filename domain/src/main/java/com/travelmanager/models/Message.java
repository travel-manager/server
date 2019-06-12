package com.travelmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelmanager.interfaces.HateoasObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Entity(name = "messages")
@NoArgsConstructor
public class Message extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Getter
    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Getter
    @Column(name = "content")
    private String content;

    @Getter
    @OneToOne
    @JoinColumn(name = "travellers_id",referencedColumnName = "id")
    private Traveller traveller;

    @Getter
    @ManyToOne
    @JoinColumn(name = "trips_id", referencedColumnName = "id")
    private Trip trip;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Message(Timestamp timestamp, String content, Traveller traveller, Trip trip) {
        this.timestamp = timestamp;
        this.content = content;
        this.traveller = traveller;
        this.trip = trip;
    }
}
