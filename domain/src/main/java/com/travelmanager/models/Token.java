package com.travelmanager.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travelmanager.interfaces.HateoasObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Entity(name = "token")
@NoArgsConstructor
public class Token extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    private Integer id;

    @Getter
    @Column(name = "token")
    private String token;

    @Getter
    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Getter
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Token(@JsonProperty("token") String token) {
        this.token = token;
    }


    public Token(String token, Timestamp timestamp, User user) {
        this.token = token;
        this.timestamp = timestamp;
        this.user = user;
    }
}
