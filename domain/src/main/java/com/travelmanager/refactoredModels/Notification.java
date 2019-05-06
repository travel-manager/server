package com.travelmanager.refactoredModels;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Notification {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String content;

    @Column
    private String type;

    @Column
    private Timestamp timestamp;

    @ManyToOne
    @JoinTable(name = "trips", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private Trip trip;

    @OneToOne
    @JoinTable(name = "icons", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private Icon icon;
}
