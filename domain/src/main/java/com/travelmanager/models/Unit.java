package com.travelmanager.models;

<<<<<<< HEAD:domain/src/main/java/com/travelmanager/refactoredModels/Unit.java
import com.travelmanager.interfaces.HateoasObject;
=======
import com.travelmanager.hateoas.abstracts.HateoasObject;
import lombok.Getter;
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35:domain/src/main/java/com/travelmanager/models/Unit.java
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Setter
@Entity(name = "units")
@NoArgsConstructor
public class Unit extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
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
