package com.travelmanager.models;

import com.travelmanager.hateoas.abstracts.HateoasObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Setter
@Entity(name = "roles")
@NoArgsConstructor
public class Role extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
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
}
