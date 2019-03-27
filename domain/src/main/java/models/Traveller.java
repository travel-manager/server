package models;

import enums.Gender;
import enums.Language;
import enums.Nationality;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity(name = "traveller")
public class Traveller extends StorableItem {
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

    public Traveller(int id, String username, String firstname, String surname, String email, String bio, String profilePictureURL, Double rating, Gender gender, List<Language> languageSpoken, List<Trip> tripList, Nationality nationality) {
        super(id);
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
