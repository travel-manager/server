package com.travelmanager.models;

import lombok.Getter;
import org.apache.catalina.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.List;

@Getter
@Entity
public class Trip extends ResourceSupport {
    @Id
    @GeneratedValue
    private Integer id;

    public Link getId() {
        return new Link(id.toString());
    }

    //    @Column(name = "LocationList")
    //  private List<Location> locationList;


    private String name;
    @Column(name = "picture")
    private String pictureURL;
    @Column(name = "datestart")
    private DateFormat dateStartTrip;
    @Column(name = "dateend")
    private DateFormat dateEndTrip;
    @OneToMany
    @JoinTable(name = "members")
    private List<Traveller>travellerList;
    @OneToOne
    private int owner;
//    @OneToOne
//    private Chat chat;
    @OneToMany
    @JoinTable(name = "members")
    private List<Transaction>transactionList;
    @OneToMany
    private List<Marker> markerList;
    //  private List<Notification>notificationList;

    @Column(name = "lat")
    private float latitude;

    @Column(name = "long")
    private float longitude;

    @Column(name = "public")
    private int isPublic;

    private String description;

    public Trip(String name, String pictureURL, DateFormat dateStartTrip, DateFormat dateEndTrip, List<Traveller> travellerList, int owner, List<Transaction> transactionList, List<Marker> markerList, float latitude, float longitude, int isPublic, String description) {
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
    }
}
