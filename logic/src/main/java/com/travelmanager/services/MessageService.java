package com.travelmanager.services;

import com.travelmanager.models.WebsocketMessage;
import com.travelmanager.repositories.IMarkerRepository;
import com.travelmanager.repositories.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
}
