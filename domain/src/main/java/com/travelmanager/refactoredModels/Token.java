package com.travelmanager.refactoredModels;

import com.travelmanager.hateoas.abstracts.HateoasObject;
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

    public Token(String token, Timestamp timestamp, User user) {
        this.token = token;
        this.timestamp = timestamp;
        this.user = user;
    }
}
