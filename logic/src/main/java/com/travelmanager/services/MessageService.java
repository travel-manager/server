package com.travelmanager.services;

import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.models.Marker;
import com.travelmanager.models.WebsocketMessage;
import com.travelmanager.repositories.IMarkerRepository;
import com.travelmanager.repositories.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;

public class MessageService  extends HateoasService<WebsocketMessage, Integer> {

    private IMarkerRepository repo;

    @Autowired
    public MessageService(IMessageRepository _repo) {
        super(_repo);
    }

    @Override
    public Class<? extends HateoasService<WebsocketMessage, Integer>> getClazz() {
        return this.getClass();
    }

    @Override
    public Class<? extends ResourceSupport> getType() {
        return WebsocketMessage.class;
    }
}
