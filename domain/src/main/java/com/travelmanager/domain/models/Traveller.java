package com.travelmanager.domain.models;

import com.travelmanager.domain.enums.Gender;
import com.travelmanager.domain.enums.Language;
import com.travelmanager.domain.enums.Nationality;
import com.travelmanager.hateoas.abstracts.PersistenceEntity;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity(name = "traveller")
public class Traveller extends PersistenceEntity<Integer> {
    @Column(name = "UserName")
    private String username;
    @Column(name = "FirstName")
    private String firstname;
    @Column(name = "LastName")
    private String surname;
    @Column(name = "Mail")
    private String email;
    @Column(name = "Bio")
    private String bio;
    @Column(name = "Picture")
    private String profilePictureURL;
    @Column(name = "Rating")
    private Double rating;
    @Column(name = "Gender")
    private Gender gender;
    @OneToMany
    private List<Language> languageSpoken;
    @OneToMany
    private List<Trip> tripList;
    private Nationality nationality;

    public Traveller() {
    }

    public Traveller(String username, String firstname, String surname, String email, String bio, String profilePictureURL, Double rating, Gender gender, List<Language> languageSpoken, List<Trip> tripList, Nationality nationality) {
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.bio = bio;
        this.profilePictureURL = profilePictureURL;
        this.rating = rating;
        this.gender = gender;
        this.languageSpoken = languageSpoken;
        this.tripList = tripList;
        this.nationality = nationality;
    }
}
