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

@Setter
@Entity(name = "Travellers")
public class Traveller extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Getter
    @Column(name = "username")
    private String username;
    @Getter
    @Column(name = "firstname")
    private String firstname;
    @Getter
    @Column(name = "lastname")
    private String surname;
//    @Column(name = "Mail")
//    private String email;
    @Getter
    @Column(name = "bio")
    private String bio;
    @Getter
    @Column(name = "picture")
    private String profilePictureURL;
//    @Column(name = "Rating")
//    private Double rating;
//    @Column(name = "Gender")
//    private Gender gender;
    @Getter
    @Column(name = "country")
    private String country;
//    @Getter
//    @Column(name = "password")
//    private String password;

    //private List<Language> languageSpoken;
//    @Getter
//    @OneToMany
//    @JoinTable(name="members")
//    private List<Trip> tripList;

    //private Nationality nationality;

    public Traveller() {
    }

    public Traveller(String username, String firstname, String surname, String bio, String profilePictureURL, String country) {
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.bio = bio;
        this.profilePictureURL = profilePictureURL;
        this.country = country;
        //this.tripList = tripList;
    }
}
