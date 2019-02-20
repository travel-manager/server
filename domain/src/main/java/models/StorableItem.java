package models;

import lombok.Getter;

@Getter
public abstract class StorableItem {
    int id;

    public StorableItem(int id){
        this.id = id;
    }
}
