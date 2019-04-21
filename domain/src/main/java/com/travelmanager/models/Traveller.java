package com.travelmanager.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Travellers")
@NoArgsConstructor
@AllArgsConstructor
public class Traveller extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
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
    @Getter
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "members",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "trips_id")})
    private List<Trip> tripList;

    //private Nationality nationality;

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
