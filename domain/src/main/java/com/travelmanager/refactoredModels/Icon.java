package com.travelmanager.refactoredModels;

import javax.persistence.*;

@Entity
public class Icon {
    @Id
    @GeneratedValue
    private int id;

    @Lob
    @Column
    private byte[] icon;
}
