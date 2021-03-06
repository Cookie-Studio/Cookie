package top.cookie.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListenerManager {
    private final Map<Integer,ArrayList<ListenerMethod>> methodMap = new HashMap<>();
    public ListenerManager(){
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

    public Map<Integer, ArrayList<ListenerMethod>> getMethodMap() {
        return methodMap;
    }

    public void registerListener(Listener listener){
        for(Method method : listener.getClass().getMethods()){
            if (!method.isAnnotationPresent(EventHandler.class)){
                continue;
            }
            getMethodMap().get(method.getAnnotation(EventHandler.class).priority()).add(new ListenerMethod(method,listener));
        }
    }
    public void callAllListener(Event event){
        for (int i = PriorityType.LOWEST;i<= PriorityType.HIGHEST;i++){
            for (ListenerMethod lm : getMethodMap().get(i)){
                if (!event.isCancelled())
                    if (lm.isMatchEvent(event))
                        try {
                            lm.getMethod().invoke(this,event);
                        } catch (Exception e) {
                            new EventException(e).printStackTrace();
                        }
                else
                    if (lm.isMatchEvent(event) && lm.isIgnoreCanceled())
                        try {
                            lm.getMethod().invoke(this,event);
                        } catch (Exception e) {
                            new EventException(e).printStackTrace();
                        }
            }
        }
    }
    private class ListenerMethod{
        public int priority;
        public boolean isIgnoreCanceled;
        public Method method;
        public Listener instance;

        public int getPriority() {
            return priority;
        }

        public boolean isIgnoreCanceled() {
            return isIgnoreCanceled;
        }

        public Method getMethod() {
            return method;
        }

        public ListenerMethod(Method method,Listener instance){
            EventHandler annotation = method.getAnnotation(EventHandler.class);
            this.method = method;
            this.isIgnoreCanceled = annotation.IgnoreCanceled();
            this.priority = annotation.priority();
            this.instance = instance;
        }
        public boolean isMatchEvent(Event event){
            return this.method.getParameterTypes()[0] == event.getClass();
        }
    }
}
