package models;

import lombok.Getter;

import java.text.DateFormat;
import java.util.List;

@Getter
public class Trip {
    private List<Location> locationList;
    private String name;
    private String pictureURL;
    private DateFormat dateStartTrip;
    private DateFormat dateEndTrip;
    private List<Traveller>travellerList;
    private Traveller owner;
    private Chat chat;
    private List<Transaction>transactionList;
    private List<Marker> markerList;
    private List<Notification>notificationList;

    public Trip(List<Location> locationList, String name, String pictureURL, DateFormat dateStartTrip, DateFormat dateEndTrip, List<Traveller> travellerList, Traveller owner, Chat chat, List<Transaction> transactionList, List<Marker> markerList, List<Notification> notificationList) {
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
