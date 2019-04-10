package com.travelmanager.models;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Entity(name = "message")
public class Message  extends ResourceSupport {
    @Id
    @GeneratedValue
    private Integer id;

    public Link getId() {
        return new Link(id.toString());
    }
    @OneToOne
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
