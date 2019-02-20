package models;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Message extends StorableItem{
    private Traveller sender;
    private String content;
    private Timestamp timeSent;

    public Message(int id, Traveller sender, String content, Timestamp timeSent) {
        super(id);
        this.sender = sender;
        this.content = content;
        this.timeSent = timeSent;
    }
}
