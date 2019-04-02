package com.travelmanager.domain.models;

import com.travelmanager.hateoas.abstracts.PersistenceEntity;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

@Getter
public class Location extends PersistenceEntity<Integer> {
    private String continent;
    private String country;
    private String region;
    private String city;
    private String residenceURL;

    public Location(int id, String continent, String country, String region, String city, String residenceURL) {
        this.continent = continent;
        this.country = country;
        this.region = region;
        this.city = city;
        this.residenceURL = residenceURL;
    }
}
