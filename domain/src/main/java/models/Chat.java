package models;

import lombok.Getter;

import java.util.List;

@Getter
public class Chat extends StorableItem{
    private List<Message> messages;

    public Chat(int id){
        super(id);
    }
}

