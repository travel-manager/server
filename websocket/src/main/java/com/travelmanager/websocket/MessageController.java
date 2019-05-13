package com.travelmanager.websocket;

import com.travelmanager.models.Message;
import com.travelmanager.services.MessageService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Setter
    private MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @MessageMapping("/message")
    @SendTo("/chat/response")
    public ResponseEntity sendMessage(Message msg){
        service.create(msg);
        return new ResponseEntity<>(msg, HttpStatus.valueOf(200));
    }
}
