package com.travelmanager.refactoredModels;

import com.travelmanager.interfaces.HateoasObject;
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
    @GeneratedValue
    private int id;

    @Column
    private Timestamp timestamp;

    @Column
    private String content;

    @OneToOne
    @JoinColumn(name = "travellers_id",referencedColumnName = "id")
    private Traveller traveller;

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
