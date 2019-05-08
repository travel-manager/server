package com.travelmanager.services;

import com.travelmanager.hateoas.abstracts.HateoasService;
import com.travelmanager.refactoredModels.Marker;
import com.travelmanager.refactoredModels.Message;
import com.travelmanager.repositories.IMarkerRepository;
import com.travelmanager.repositories.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageService  extends HateoasService<Message, Integer> {

    private IMarkerRepository repo;

    @Autowired
    public MessageService(IMessageRepository _repo) {
        super(_repo);
    }

    @Override
    public Class<? extends HateoasService<Message, Integer>> getClazz() {
        return this.getClass();
    }
}
