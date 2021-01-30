package top.cookie.event;

public class Event {
    private boolean isCancelled = false;

    public boolean isCancelled() {
        if (!(this instanceof Cancellable)) {
            throw new EventException("Event is not Cancellable");
        }
        return isCancelled;
    }

    public void setCancelled() {
        setCancelled(true);
    }

    public void setCancelled(boolean value) {
        if (!(this instanceof Cancellable)) {
            throw new EventException("Event is not Cancellable");
        }
        isCancelled = value;
    }
}
