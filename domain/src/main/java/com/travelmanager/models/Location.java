package com.travelmanager.models;

<<<<<<< HEAD:domain/src/main/java/com/travelmanager/refactoredModels/Location.java
import com.travelmanager.interfaces.HateoasObject;
=======
import com.travelmanager.hateoas.abstracts.HateoasObject;
import lombok.Getter;
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35:domain/src/main/java/com/travelmanager/models/Location.java
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Entity(name = "location")
@NoArgsConstructor
public class Location extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    private Integer id;

    @Getter
    @Column(name = "latitude")
    private float latitude;

    @Getter
    @Column(name = "longtitude")
    private float longtitude;

    @Getter
    @Column(name = "city")
    private String city;

    @Getter
    @Column(name = "country")
    private String country;

    @Getter
    @Lob
    @Column(name = "flag")
    private byte[] flag;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Location(float latitude, float longtitude, String city, String country, byte[] flag) {
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.city = city;
        this.country = country;
        this.flag = flag;
    }
}
