package top.cookie.event.listener;

import java.util.ArrayList;

public class ListenerRegister {

    private static ArrayList<Class<Listener>> listeners = new ArrayList<>();

    public static void registerListener(Listener listener){
        listeners.add((Class<Listener>) listener.getClass());
    }

    public ArrayList<Class<Listener>> getListeners(){
        return listeners;
    }
}
