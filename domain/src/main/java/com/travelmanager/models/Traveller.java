package com.travelmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelmanager.enums.Gender;
import com.travelmanager.enums.Language;
import com.travelmanager.enums.Nationality;
import com.travelmanager.hateoas.abstracts.HateoasObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Entity(name = "travellers")
public class Traveller extends ResourceSupport  implements HateoasObject{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column(name = "username")
    private String username;
    @Getter
    @Column(name = "firstname")
    private String firstname;
    @Getter
    @Column(name = "lastname")
    private String lastname;
//    @Column(name = "Mail")
//    private String email;
    @Getter
    @Column(name = "bio")
    private String bio;
    @Getter
    @Column(name = "picture")
    private String picture;
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
    @Getter
    @OneToMany
    @JoinTable(name="members")
    private transient List<Trip> trips;

    //private Nationality nationality;

    public Traveller() {
    }

    public Traveller(String username, String firstname, String surname, String bio, String profilePictureURL, String country, List<Trip> trips) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = surname;
        this.bio = bio;
        this.picture = profilePictureURL;
        this.country = country;
        this.trips = trips;
    }

    @Override
    @JsonIgnore
    public Serializable getIdentifier() {
        return this.id;
    }
}
