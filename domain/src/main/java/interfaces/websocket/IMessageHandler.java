package interfaces.websocket;

public interface IMessageHandler {

    void handleMessage(String message, String sessionId);
}
