package com.travelmanager.domain.models;

import com.travelmanager.domain.enums.NotificationType;
import com.travelmanager.hateoas.abstracts.PersistenceEntity;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import java.sql.Timestamp;

@Getter
public class Notification extends PersistenceEntity<Integer> {
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
