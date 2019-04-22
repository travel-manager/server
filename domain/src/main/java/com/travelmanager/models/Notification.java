package com.travelmanager.models;

import com.travelmanager.enums.NotificationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Entity(name = "Notifications")
public class Notification extends ResourceSupport {
    @Id
    @GeneratedValue
    public Integer id;

    @Getter
    @Column(name = "timestamp")
    private String timestamp;
    @Getter
    @Column(name = "type")
    private String type;
    @Getter
    @Column(name = "content")
    private String content;
    @Getter
    @Column(name = "icon")
    private String icon;
    @Getter
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
}
