package com.travelmanager.domain.models;

import com.travelmanager.hateoas.abstracts.PersistenceEntity;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Getter
@Entity(name = "message")
public class Message extends PersistenceEntity<Integer> {
    @OneToOne
    @Column(name = "Sender")
    private Traveller sender;
    @Column(name = "MessageContent")
    private String content;
    @Column(name = "TimeStamp")
    private Timestamp timeSent;

    public Message(Traveller sender, String content, Timestamp timeSent) {
        this.sender = sender;
        this.content = content;
        this.timeSent = timeSent;
    }
}
