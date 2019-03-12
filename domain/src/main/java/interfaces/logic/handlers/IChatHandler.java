package interfaces.logic.handlers;

import interfaces.ICRUD;
import models.Chat;
import models.Message;

public interface IChatHandler extends ICRUD<Chat, Integer> {
    int getMessagesFromChat(Chat chat);
}
