package com.travelmanager.refactoredModels;

import javax.persistence.*;

@Entity(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private double amount;

    @Column
    private String subject;

    @OneToOne
    @JoinTable(name = "units",joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private Unit unit;

    @OneToOne
    @JoinTable(name = "travellers",joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private Traveller traveller;

    @OneToOne
    @JoinTable(name = "trips",joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private Trip trip;

}
