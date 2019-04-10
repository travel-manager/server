package com.travelmanager.hateoas.abstracts;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
public abstract class PersistenceEntity<Identifier extends Serializable> extends ResourceSupport {

    @Id
    @GeneratedValue
    private Identifier id;

    public Link getId() {
        return new Link(id.toString());
    }

}
