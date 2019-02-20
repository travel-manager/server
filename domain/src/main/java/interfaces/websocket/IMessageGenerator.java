package interfaces.websocket;

public interface IMessageGenerator {

    void processMessage(String sessionId, String type, String data);

    void handleDisconnect(String sessionId);
}
