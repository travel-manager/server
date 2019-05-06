package com.travelmanager.refactoredModels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "roles")
@Getter @Setter
public class Role {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String role;
}
