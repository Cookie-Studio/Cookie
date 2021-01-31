package top.cookie.event;

public class EventException extends RuntimeException{

    public EventException(Exception e) {
        super(e);
    }

    public EventException(String message) {
        super(message);
    }
}
