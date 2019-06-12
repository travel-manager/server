package com.travelmanager.models;

import com.travelmanager.interfaces.HateoasObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Entity(name = "roles")
@NoArgsConstructor
public class Role extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column(name = "role")
    private String role;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Role(String role) {
        this.role = role;
    }
    public Role(Integer id, String role) {
        this.role = role;this.id = id;
    }


}
