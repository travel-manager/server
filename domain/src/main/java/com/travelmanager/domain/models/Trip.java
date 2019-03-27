package com.travelmanager.domain.models;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.text.DateFormat;
import java.util.List;

@Getter
@Entity(name = "trip")
public class Trip extends StorableItem{
    private List<Location> locationList;
    @Column(name = "Name")
    private String name;
    @Column(name = "Picture")
    private String pictureURL;
    @Column(name = "DateStart")
    private DateFormat dateStartTrip;
    @Column(name = "DateEnd")
    private DateFormat dateEndTrip;
    @OneToMany
    private List<Traveller>travellerList;
    @OneToOne
    @Column(name = "Owner")
    private Traveller owner;
    @OneToOne
    @Column(name = "ChatId")
    private Chat chat;
    @OneToMany
    private List<Transaction>transactionList;
    @OneToMany
    private List<Marker> markerList;
    private List<Notification>notificationList;

    public Trip(int id, List<Location> locationList, String name, String pictureURL, DateFormat dateStartTrip, DateFormat dateEndTrip, List<Traveller> travellerList, Traveller owner, Chat chat, List<Transaction> transactionList, List<Marker> markerList, List<Notification> notificationList) {
        super(id);
        this.locationList = locationList;
        this.name = name;
        this.pictureURL = pictureURL;
        this.dateStartTrip = dateStartTrip;
        this.dateEndTrip = dateEndTrip;
        this.travellerList = travellerList;
        this.owner = owner;
        this.chat = chat;
        this.transactionList = transactionList;
        this.markerList = markerList;
        this.notificationList = notificationList;
    }
}
