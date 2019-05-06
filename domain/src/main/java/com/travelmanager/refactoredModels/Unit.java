package com.travelmanager.refactoredModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "units")
public class Unit {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String unit;
}
