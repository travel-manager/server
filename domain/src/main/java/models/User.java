package models;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Entity(name="User")
public class User {

    @Column(name = "Password")
    private String password;
    @Column(name = "Username")
    private String username;
}
