package models;

import enums.NotificationType;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Notification extends StorableItem {
    private Timestamp timeNotified;
    private NotificationType type;
    private String content;
    private String title;

    public Notification(int id, Timestamp timeNotified, NotificationType type, String content, String title) {
        super(id);
        this.timeNotified = timeNotified;
        this.type = type;
        this.content = content;
        this.title = title;
    }
}
