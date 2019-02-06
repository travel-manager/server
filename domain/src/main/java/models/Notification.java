package models;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Notification {
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
