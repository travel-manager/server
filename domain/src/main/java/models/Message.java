package models;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Message {
    private Traveller sender;
    private String content;
    private Timestamp timeSent;

    public Message(Traveller sender, String content, Timestamp timeSent) {
        this.sender = sender;
        this.content = content;
        this.timeSent = timeSent;
    }
}
