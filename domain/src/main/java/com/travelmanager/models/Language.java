package com.travelmanager.models;

import com.travelmanager.interfaces.HateoasObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Entity(name = "languages")
@NoArgsConstructor
public class Language extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column(name = "language")
    private String language;

    @Override
    public Serializable getIdentifier() {
        return this.id;
    }

    public Language(String language) {
        this.language = language;
    }
}
