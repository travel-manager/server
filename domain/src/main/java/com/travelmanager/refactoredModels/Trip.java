package com.travelmanager.refactoredModels;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "trips")
public class Trip {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinTable(name = "location", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private Location location;

    @Column
    private String name;

    @Column
    private Date datestart;

    @Column
    private Date dateend;

    @Column
    private String description;

    @Column(name = "public")
    private boolean isPublic;

    @Lob
    @Column
    private byte[] picture;
}
