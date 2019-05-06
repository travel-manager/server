package com.travelmanager.refactoredModels;

import javax.persistence.*;

@Entity(name = "travellers")
public class Traveller {
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
    @JoinTable(name = "user",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private User user;


    @OneToOne
    @JoinTable(name = "location",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private Location location;
}
