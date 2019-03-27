package com.travelmanager.domain.models;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Getter
@Entity(name = "message")
public class Message extends StorableItem{
    @OneToOne
    @Column(name = "Sender")
    private Traveller sender;
    @Column(name = "MessageContent")
    private String content;
    @Column(name = "TimeStamp")
    private Timestamp timeSent;

    public Message(int id, Traveller sender, String content, Timestamp timeSent) {
        super(id);
        this.sender = sender;
        this.content = content;
        this.timeSent = timeSent;
    }
}
