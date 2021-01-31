package top.cookie.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Listeners {
    private static final Map<Integer,ArrayList<ListenerMethod>> methodMap = new HashMap<>();
    static{
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

    public static Map<Integer, ArrayList<ListenerMethod>> getMethodMap() {
        return methodMap;
    }

    public static void registerListener(Class<Listener> listener){
        for(Method method : listener.getMethods()){
            if (!method.isAnnotationPresent(EventHandler.class)){
                continue;
            }
            getMethodMap().get(method.getAnnotation(EventHandler.class).priority()).add(new ListenerMethod(method));
        }
    }
    public static void callAllListener(Event event){
        for (int i = PriorityType.LOWEST;i<= PriorityType.HIGHEST;i++){
            for (ListenerMethod lm : getMethodMap().get(i)){
                if (!event.isCancelled())
                    if (lm.isMatchEvent(event))
                        try {
                            lm.getMethod().invoke(event);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                else
                    if (lm.isMatchEvent(event) && lm.isIgnoreCanceled())
                        try {
                            lm.getMethod().invoke(event);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
            }
        }
    }
    private static class ListenerMethod{
        public int priority;
        public boolean isIgnoreCanceled;
        public Method method;

        public int getPriority() {
            return priority;
        }

        public boolean isIgnoreCanceled() {
            return isIgnoreCanceled;
        }

        public Method getMethod() {
            return method;
        }

        public ListenerMethod(Method method){
            EventHandler annotation = method.getAnnotation(EventHandler.class);
            this.method = method;
            this.isIgnoreCanceled = annotation.IgnoreCanceled();
            this.priority = annotation.priority();
        }
        public boolean isMatchEvent(Event event){
            return this.method.getParameterTypes()[0] == event.getClass();
        }
    }
}
