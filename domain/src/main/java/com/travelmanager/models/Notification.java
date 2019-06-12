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
@Entity(name = "notifications")
@NoArgsConstructor
public class Notification extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Getter
    @Column(name = "content")
    private String content;

    @Getter
    @Column(name = "type")
    private String type;

    @Getter
    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Getter
    @ManyToOne
    @JoinColumn(name = "trips_id", referencedColumnName = "id")
    private Trip trip;

    @Getter
    @OneToOne
    @JoinColumn(name = "icons_id", referencedColumnName = "id")
    private Icon icon;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Notification(String content, String type, Timestamp timestamp, Trip trip, Icon icon) {
        this.content = content;
        this.type = type;
        this.timestamp = timestamp;
        this.trip = trip;
        this.icon = icon;
    }
}
