package com.travelmanager.refactoredModels;

import com.travelmanager.interfaces.HateoasObject;
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
    @GeneratedValue
    private int id;

    @Column
    private String content;

    @Column
    private String type;

    @Column
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name = "trips_id", referencedColumnName = "id")
    private Trip trip;

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
