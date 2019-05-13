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
@Entity(name = "notifications")
@NoArgsConstructor
public class Notification extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
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
