package com.travelmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelmanager.interfaces.HateoasObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Entity(name = "travellers")
@NoArgsConstructor
public class Traveller extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Getter
    @Column(name = "firstname")
    private String firstname;

    @Getter
    @Column(name = "lastname")
    private String lastname;

    @Getter
    @Lob
    @Column(name = "picture")
    private byte[] picture;

    @Getter
    @Column(name = "bio")
    private String bio;

    @Getter
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Getter
    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @Getter
    @OneToMany
    @JoinTable(name = "travellers_spoken_languages", joinColumns = @JoinColumn(name = "travellers_id"), inverseJoinColumns = @JoinColumn(name = "languages_id"))
    private List<Language> languages;

    @Getter
    @OneToMany
    @JoinTable(name = "members", joinColumns = @JoinColumn(name = "travellers_id"), inverseJoinColumns = @JoinColumn(name = "trips_id"))
    private List<Trip> trips;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Traveller(String firstname, String lastname, byte[] picture, String bio, User user, Location location, List<Language> languages) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.picture = picture;
        this.bio = bio;
        this.user = user;
        this.location = location;
        this.languages = languages;
    }
}
