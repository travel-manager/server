package com.travelmanager.models;

import com.travelmanager.hateoas.abstracts.HateoasObject;
import lombok.Getter;
<<<<<<< HEAD
import lombok.Setter;
=======
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35

import javax.persistence.*;
import java.io.Serializable;

@Setter
<<<<<<< HEAD
@Getter
@Entity(name="User")
public class User {

=======
@Entity(name = "user")
@NoArgsConstructor
public class User extends ResourceSupport implements HateoasObject {
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35
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

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getIdentifier(){
        return id;
    }
}
