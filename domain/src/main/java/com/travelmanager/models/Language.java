package com.travelmanager.models;

<<<<<<< HEAD:domain/src/main/java/com/travelmanager/refactoredModels/Language.java
import com.travelmanager.interfaces.HateoasObject;
=======
import com.travelmanager.hateoas.abstracts.HateoasObject;
import lombok.Getter;
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35:domain/src/main/java/com/travelmanager/models/Language.java
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Setter
@Entity(name = "languages")
@NoArgsConstructor
public class Language extends ResourceSupport implements HateoasObject {
    @Id
    @GeneratedValue
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
