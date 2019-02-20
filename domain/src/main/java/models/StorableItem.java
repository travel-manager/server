package models;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public abstract class StorableItem {
    @Id
    int id;

    public StorableItem(int id){
        this.id = id;
    }
}
