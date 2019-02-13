package models;

import lombok.Getter;

@Getter
public class Location {
    private String continent;
    private String country;
    private String region;
    private String city;
    private String residenceURL;

    public Location(String continent, String country, String region, String city, String residenceURL) {
        this.continent = continent;
        this.country = country;
        this.region = region;
        this.city = city;
        this.residenceURL = residenceURL;
    }
}
