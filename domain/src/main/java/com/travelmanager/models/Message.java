package com.travelmanager.models;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelmanager.interfaces.HateoasObject;
=======
import com.travelmanager.hateoas.abstracts.HateoasObject;
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Entity(name = "messages")
@NoArgsConstructor
public class Message extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
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
