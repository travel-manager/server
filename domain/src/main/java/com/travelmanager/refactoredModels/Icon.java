package com.travelmanager.refactoredModels;

import com.travelmanager.hateoas.abstracts.HateoasObject;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Entity(name = "icons")
@NoArgsConstructor
public class Icon extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
    private int id;

    @Lob
    @Column
    private byte[] icon;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Icon(byte[] icon) {
        this.icon = icon;
    }
}
