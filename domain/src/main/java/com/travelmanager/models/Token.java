package com.travelmanager.models;

<<<<<<< HEAD:domain/src/main/java/com/travelmanager/refactoredModels/Token.java
import com.fasterxml.jackson.annotation.JsonProperty;
import com.travelmanager.interfaces.HateoasObject;
=======
import com.travelmanager.hateoas.abstracts.HateoasObject;
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35:domain/src/main/java/com/travelmanager/models/Token.java
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

<<<<<<< HEAD:domain/src/main/java/com/travelmanager/refactoredModels/Token.java
    @Column
    @Getter
    private String token;

    @Column
    @Getter
=======
    @Getter
    @Column(name = "token")
    private String token;

    @Getter
    @Column(name = "timestamp")
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35:domain/src/main/java/com/travelmanager/models/Token.java
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
