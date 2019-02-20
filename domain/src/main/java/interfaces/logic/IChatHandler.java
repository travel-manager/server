package interfaces.logic;

import models.Chat;
import models.Message;

public interface IChatHandler {
    void sendMessage(Message message);
    void getMessagesFromChat(Chat chat);
    void deleteChat(Chat chat);
}
