package com.travelmanager.refactoredModels;

import com.travelmanager.hateoas.abstracts.HateoasObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Setter
@Entity(name = "trips")
@NoArgsConstructor
public class Trip extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    private Integer id;

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

    @Column(name = "dateend")
    private Date dateend;

    @Getter
    @Column(name = "description")
    private String description;

    @Getter
    @Column(name = "public")
    private boolean isPublic;

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
