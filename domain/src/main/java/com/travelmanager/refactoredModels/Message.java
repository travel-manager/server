package com.travelmanager.refactoredModels;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private Timestamp timestamp;

    @Column
    private String content;

    @OneToOne
    @JoinTable(name = "travellers", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private Traveller traveller;

    @ManyToOne
    @JoinTable
    private Trip trip;
}
