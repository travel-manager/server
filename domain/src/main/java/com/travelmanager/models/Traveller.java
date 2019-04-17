package com.travelmanager.models;

import com.travelmanager.enums.Gender;
import com.travelmanager.enums.Language;
import com.travelmanager.enums.Nationality;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "Travellers")
public class Traveller extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Override
    public Link getId() {return new Link(id.toString());}

    @Column(name = "username")
    private String username;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String surname;
//    @Column(name = "Mail")
//    private String email;
    @Column(name = "bio")
    private String bio;
    @Column(name = "picture")
    private String profilePictureURL;
//    @Column(name = "Rating")
//    private Double rating;
//    @Column(name = "Gender")
//    private Gender gender;
    @Column(name = "country")
    private String country;

    //private List<Language> languageSpoken;
    @OneToMany
    @JoinTable(name="members")
    private List<Trip> tripList;

    //private Nationality nationality;

    public Traveller() {
    }

    public Traveller(String username, String firstname, String surname, String bio, String profilePictureURL, String country, List<Trip> tripList) {
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.bio = bio;
        this.profilePictureURL = profilePictureURL;
        this.country = country;
        this.tripList = tripList;
    }
}
