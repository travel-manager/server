package com.travelmanager.domain.models;

import com.travelmanager.hateoas.abstracts.PersistenceEntity;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity(name = "chat")
public class Chat extends PersistenceEntity<Integer> {
    @OneToMany
    private List<Message> messages;

    public Chat(){

    }
}

