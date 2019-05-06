package com.travelmanager.refactoredModels;

import javax.persistence.*;
import java.sql.Blob;

@Entity(name = "location")
public class Location {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private float latitude;

    @Column
    private float longtitude;

    @Column
    private String city;

    @Column
    private String country;

    @Lob
    @Column
    private byte[] flag;
}
