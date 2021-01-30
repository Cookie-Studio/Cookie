package top.cookie.event.listener;

import top.cookie.event.Event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListenerManager {
    private final Map<Integer,ArrayList<ListenerMethod>> methodMap = new HashMap<>();
    {
        methodMap.put(PriorityType.LOWEST,new ArrayList<>());
        methodMap.put(PriorityType.LOWER,new ArrayList<>());
        methodMap.put(PriorityType.LOW,new ArrayList<>());
        methodMap.put(PriorityType.MEDIUMLOW,new ArrayList<>());
        methodMap.put(PriorityType.MEDIUM,new ArrayList<>());
        methodMap.put(PriorityType.MEDIUMHIGH,new ArrayList<>());
        methodMap.put(PriorityType.HIGH,new ArrayList<>());
        methodMap.put(PriorityType.HIGHER,new ArrayList<>());
        methodMap.put(PriorityType.HIGHEST,new ArrayList<>());
    }
    public void registerListener(Class<Listener> listener){
        for(Method method : listener.getMethods()){
            if (!method.isAnnotationPresent(EventHandler.class)){
                continue;
            }
            methodMap.get(method.getAnnotation(EventHandler.class).priority()).add(new ListenerMethod(method));
        }
    }
    public void callAllListener(Event event){
        for (int i = PriorityType.HIGHEST;i <= PriorityType.LOWEST; i++){
            for (ListenerMethod m : methodMap.get(i)){
                if (event.isCancelled()){
                    if (!m.isIgnoreCanceled){
                        continue;
                    }
                    try {
                        m.method.invoke(event);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                try {
                    m.method.invoke(event);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class ListenerMethod{
        public int priority;
        public boolean isIgnoreCanceled;
        public Method method;
        public ListenerMethod(Method method){
            EventHandler annotation = method.getAnnotation(EventHandler.class);
            this.method = method;
            this.isIgnoreCanceled = annotation.IgnoreCanceled();
            this.priority = annotation.priority();
        }
    }
}
