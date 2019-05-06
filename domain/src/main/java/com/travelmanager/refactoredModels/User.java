package com.travelmanager.refactoredModels;

import javax.persistence.*;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @OneToOne
    @JoinTable(name = "roles",joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private Role role;
}
