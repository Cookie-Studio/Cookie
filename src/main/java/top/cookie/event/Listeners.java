package top.cookie.event;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Listeners {
    private static final Map<Integer,ArrayList<ListenerMethod>> methodmap = new HashMap<>();
    static{
        methodmap.put(PriorityType.LOWEST,new ArrayList<>());
        methodmap.put(PriorityType.LOWER,new ArrayList<>());
        methodmap.put(PriorityType.LOW,new ArrayList<>());
        methodmap.put(PriorityType.MEDIUMLOW,new ArrayList<>());
        methodmap.put(PriorityType.MEDIUM,new ArrayList<>());
        methodmap.put(PriorityType.MEDIUMHIGH,new ArrayList<>());
        methodmap.put(PriorityType.HIGH,new ArrayList<>());
        methodmap.put(PriorityType.HIGHER,new ArrayList<>());
        methodmap.put(PriorityType.HIGHEST,new ArrayList<>());
    }
    public static void registerListener(Class<Listener> listener){
        for(Method method : listener.getMethods()){
            if (!method.isAnnotationPresent(EventHandler.class)){
                continue;
            }
            methodmap.get(method.getAnnotation(EventHandler.class).priority()).add(new ListenerMethod(method));
        }
    }
    public static void callAllListener(Event event){

    }
    private static class ListenerMethod{
        public int priority;
        public boolean isIgnoreCanceled;
        public Method method;
        public ListenerMethod(Method method){
            EventHandler annotation = method.getAnnotation(EventHandler.class);
            this.method = method;
            this.isIgnoreCanceled = annotation.ifIgnoreCanceled();
            this.priority = annotation.priority();
        }
    }
}
