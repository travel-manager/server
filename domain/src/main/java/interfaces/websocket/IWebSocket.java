package interfaces.websocket;

public interface IWebSocket {

    void sendTo(String sessionId, Object object);

    void broadcast(Object object);

    void start();

    void stop();

    void setMessageProcessor(IMessageProcessor processor);
}
