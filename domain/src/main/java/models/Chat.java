package models;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity(name = "chat")
public class Chat extends StorableItem{
    @OneToMany
    private List<Message> messages;

    public Chat(int id){
        super(id);
    }
}

