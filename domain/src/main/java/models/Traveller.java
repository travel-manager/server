package models;

import enums.Gender;
import enums.Language;
import enums.Nationality;
import lombok.Getter;
import java.util.List;

@Getter
public class Traveller {
    private String username;
    private String firstname;
    private String surname;
    private String email;
    private String bio;
    private String profilePictureURL;
    private Double rating;
    private Gender gender;
    private List<Language> languageSpoken;
    private List<Trip> tripList;
    private Nationality nationality;

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
