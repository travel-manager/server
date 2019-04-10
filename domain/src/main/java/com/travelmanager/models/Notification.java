package com.travelmanager.models;

import com.travelmanager.enums.NotificationType;
import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
public class Notification extends ResourceSupport {
    @Id
    @GeneratedValue
    private Integer id;

    public Link getId() {
        return new Link(id.toString());
    }
    private Timestamp timeNotified;
    private NotificationType type;
    private String content;
    private String title;

    public Notification(Timestamp timeNotified, NotificationType type, String content, String title) {
        this.timeNotified = timeNotified;
        this.type = type;
        this.content = content;
        this.title = title;
    }
}
