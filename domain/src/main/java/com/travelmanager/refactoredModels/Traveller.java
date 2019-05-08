package com.travelmanager.refactoredModels;

import com.travelmanager.interfaces.HateoasObject;
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
    @GeneratedValue
    private int id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Lob
    @Column
    private byte[] picture;

    @Column
    private String bio;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToMany
    @JoinTable(name = "travellers_spoken_languages", joinColumns = @JoinColumn(name = "travellers_id"), inverseJoinColumns = @JoinColumn(name = "languages_id"))
    private List<Language> languages;

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
