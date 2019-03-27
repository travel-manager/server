package com.travelmanager.domain.models;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public abstract class StorableItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public StorableItem(int id){
        this.id = id;
    }
}
