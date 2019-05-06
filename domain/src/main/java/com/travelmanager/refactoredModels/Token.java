package com.travelmanager.refactoredModels;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Token {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String token;

    @Column
    private Timestamp timestamp;

    @OneToOne
    @JoinTable(name = "user",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private User user;
}
