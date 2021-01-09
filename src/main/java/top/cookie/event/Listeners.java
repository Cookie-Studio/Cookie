package top.cookie.event;

import java.util.ArrayList;

public class Listeners {
    private static final ArrayList<Listener> listeners = new ArrayList<>();
    public static void registerListener(Listener listener){
        listeners.add(listener);
    }
    public static ArrayList<Listener> getListeners(){
        return listeners;
    }

}
