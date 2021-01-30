package top.cookie.event;

public interface Cancellable {
    boolean isCancelled();

    void setCancelled();

    void setCancelled(boolean isCancel);
}
