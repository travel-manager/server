package com.travelmanager.refactoredModels;

import com.travelmanager.interfaces.HateoasObject;
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
    private int id;

    @Column
    private float latitude;

    @Column
    private float longtitude;

    @Column
    private String city;

    @Column
    private String country;

    @Lob
    @Column
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
