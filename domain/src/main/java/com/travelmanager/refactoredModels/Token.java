package com.travelmanager.refactoredModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travelmanager.interfaces.HateoasObject;
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
    private int id;

    @Column
    @Setter
    private String token;

    @Column
    private Timestamp timestamp;

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
