package com.travelmanager.models;

import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.List;

@Getter
@Entity(name = "Trips")
public class Trip extends ResourceSupport {
    @Id
    @GeneratedValue
    private Integer id;

    @Override
    public Link getId() {
        return new Link(id.toString());
    }

    //    @Column(name = "LocationList")
    //  private List<Location> locationList;
/*
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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",table = "travellers")
    private Traveller owner;
//    @OneToOne
//    private Chat chat;
    @OneToMany
    @JoinTable(name = "members")
    private List<Transaction>transactionList;
    @OneToMany
    private List<Marker> markerList;
    //  private List<Notification>notificationL ist;

    @Column(name = "lat")
    private float latitude;

    @Column(name = "long")
    private float longitude;

    @Column(name = "public")
    private int isPublic;

    private String description;

*/
    @Column(name = "location")
    private String location;
    @Column(name = "name")
    private String name;
    @Column(name = "picture")
    private String picture;
    @Column(name = "datestart")
    private String datestart;
    @Column(name = "dateend")
    private String dateend;
    @Column(name = "lat")
    private Float latitude;
    @Column(name = "long")
    private Float longtitude;
    @Column(name = "description")
    private String description;
    @Column(name = "public")
    private Boolean isPublic;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",table = "travellers")
    private Traveller owner;


    public Trip() {
    }

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
