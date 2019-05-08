package com.travelmanager.services;

import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Message;
import com.travelmanager.repositories.IMarkerRepository;
import com.travelmanager.repositories.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Service;

public class MessageService  extends HateoasService<Message, Integer> {

    private IMessageRepository repository;

    @Autowired
    public MessageService(IMessageRepository _repo) {
        super(_repo);
        repository = _repo;
    }

    public void update(WebsocketMessage object){
        if(repository.findById(object.id).isPresent()){
            WebsocketMessage ent = repository.findById(object.id).get();
            ent.setContent(object.getContent());
            ent.setTimestamp(object.getTimestamp());
            repository.save(ent);
        }
    }

    @Override
    public Class<? extends HateoasService<Message, Integer>> getClazz() {
        return this.getClass();
    }

    @Override
    public Class<? extends ResourceSupport> getType() {
        return WebsocketMessage.class;
    }
}
