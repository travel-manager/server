package com.travelmanager.models;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelmanager.interfaces.HateoasObject;
import lombok.Getter;
import org.springframework.hateoas.Link;
=======
import com.travelmanager.hateoas.abstracts.HateoasObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
<<<<<<< HEAD
=======
import java.sql.Date;
import java.util.List;
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35

@Setter
@Entity(name = "trips")
@NoArgsConstructor
public class Trip extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Getter
    @OneToOne
    @JoinColumn(name = "location_id",referencedColumnName = "id")
    private Location location;

    @Getter
    @Column(name = "name")
    private String name;

    @Getter
    @Column(name = "datestart")
    private Date datestart;

    @Getter
    @Column(name = "dateend")
    private Date dateend;

    @Getter
    @Column(name = "description")
    private String description;

    @Getter
    @Column(name = "public")
    private boolean isPublic;

    @Getter
    @OneToMany
    @JoinTable(name = "members", joinColumns = @JoinColumn(name = "trips_id"), inverseJoinColumns = @JoinColumn(name = "travellers_id"))
    private List<Traveller> members;

    @Getter
    @Lob
    @Column(name = "picture")
    private byte[] picture;


    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Trip(Location location, String name, Date datestart, Date dateend, String description, boolean isPublic, byte[] picture) {
        this.location = location;
        this.name = name;
        this.datestart = datestart;
        this.dateend = dateend;
        this.description = description;
        this.isPublic = isPublic;
        this.picture = picture;
    }
}
