package com.travelmanager.hateoas.abstracts;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public interface HateoasObject<Identifier extends Serializable>{
    Identifier getIdentifier();
}
