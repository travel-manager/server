package com.travelmanager.models;

import com.travelmanager.interfaces.HateoasObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Entity(name = "user")
@NoArgsConstructor
public class User extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    private Integer id;

    @Getter
    @Column(name = "username")
    private String username;

    @Getter
    @Column(name = "password")
    private String password;

    @Getter
    @OneToOne
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    private Role role;

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public Integer getIdentifier(){
        return id;
    }
}
