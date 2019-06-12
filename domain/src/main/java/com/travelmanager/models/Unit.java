package com.travelmanager.models;

import com.travelmanager.interfaces.HateoasObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Entity(name = "units")
@NoArgsConstructor
public class Unit extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column(name = "unit")
    private String unit;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Unit(String unit) {
        this.unit = unit;
    }
}
