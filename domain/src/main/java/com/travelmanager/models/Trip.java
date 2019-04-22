package com.travelmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.List;

@Setter
@Entity(name = "Trips")
@NoArgsConstructor
public class Trip extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Getter @Column(name = "location")
    private String location;
    @Getter @Column(name = "name")
    private String name;
    @Getter @Column(name = "picture")
    private String picture;
    @Getter @Column(name = "datestart")
    private String datestart;
    @Getter @Column(name = "dateend")
    private String dateend;
    @Getter @Column(name = "lat")
    private Float latitude;
    @Getter @Column(name = "long")
    private Float longtitude;
    @Getter @Column(name = "description")
    private String description;
    @Getter @Column(name = "public")
    private Boolean isPublic;

    @Getter @OneToMany(cascade = CascadeType.MERGE)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id",table = "travellers")
    @JsonIgnore
    private Traveller owner;

    @Getter @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "members",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "travellers_id")})
    private List<Traveller>travellerList;

    public Trip(String location, String name, String picture, String datestart, String dateend, Float latitude, Float longtitude, String description, Boolean isPublic, Traveller owner) {
        this.location = location;
        this.name = name;
        this.picture = picture;
        this.datestart = datestart;
        this.dateend = dateend;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.description = description;
        this.isPublic = isPublic;
        this.owner = owner;
    }

    /*public Trip(String name, String pictureURL, DateFormat dateStartTrip, DateFormat dateEndTrip, List<Traveller> travellerList, Traveller owner, List<Transaction> transactionList, List<Marker> markerList, float latitude, float longitude, int isPublic, String description) {
        this.name = name;
        this.pictureURL = pictureURL;
        this.dateStartTrip = dateStartTrip;
        this.dateEndTrip = dateEndTrip;
        this.travellerList = travellerList;
        this.owner = owner;
        this.transactionList = transactionList;
        this.markerList = markerList;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isPublic = isPublic;
        this.description = description;
    }*/
}
